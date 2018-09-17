package com.chrome.api.controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.chrome.api.dto.LoginDto;
import com.chrome.api.dto.ResponseTemplate;
import com.chrome.api.service.UserService;
import com.chrome.domain.entity.Page;
import com.chrome.domain.entity.User;
import com.chrome.infra.annotation.AuthToken;
import com.chrome.infra.util.ConstantKit;
import com.chrome.infra.util.Md5TokenGenerator;
import com.chrome.infra.util.RedisUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

/**
 * Created with IDEA
 * author:Chengcong
 * Date:2018/9/8
 * Time:9:48
 */
@RestController
@Slf4j
@RequestMapping("/api/v1/user")
public class UserController {
  


    @Autowired
    Md5TokenGenerator tokenGenerator;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ApiOperation("用户登录接口")
    public ResponseEntity<JSONObject> login(@RequestBody LoginDto loginDto) {
        Jedis jedis = RedisUtil.getJedis();

        String username = loginDto.getUsername();
        String password = loginDto.getPassword();
        User user = new User();
        user.setUserName(username);
        user.setUserPassword(tokenGenerator.passwordMd5(password));
        User currentUser = userService.login(user);
        JSONObject result = new JSONObject();
        String token;
        String message;
        if (currentUser != null) {
            token = tokenGenerator.generate(username, password);
            System.out.println(token);
            result.put("token",token);
            jedis.set(username, token);
            jedis.expire(username, ConstantKit.TOKEN_EXPIRE_TIME);
            jedis.set(token, username);
            System.out.println(jedis.get(token));
            jedis.expire(token, ConstantKit.TOKEN_EXPIRE_TIME);
            Long currentTime = System.currentTimeMillis();
            jedis.set(token + username, currentTime.toString());
            //用完关闭
            RedisUtil.returnResource(jedis);
          message="登陆成功";
          String role=userService.getRole(username);
            result.put("message",message);
            result.put("code",200);
            result.put("role",role);
            return  new ResponseEntity<>(result,HttpStatus.OK);
        } else {
            message="登陆失败";
            result.put("code",401);
            result.put("message",message);
            return  new ResponseEntity<>(result,HttpStatus.UNAUTHORIZED);
        }

    }

    @ApiOperation("获取当前用户")
    @RequestMapping(value = "/currentUser", method = RequestMethod.GET)
    @AuthToken
    public ResponseEntity<User> getCurrentUser(HttpServletRequest request) {



        String username = (String) request.getAttribute("REQUEST_CURRENT_KEY");
        User user = userService.selectByUsername(username);

        return new ResponseEntity<>(user,HttpStatus.OK);
    }


    @ApiOperation("用户登出")
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    @AuthToken
    public ResponseEntity<Object> logout(HttpServletRequest request) {
        Jedis jedis = RedisUtil.getJedis();
        String username = (String) request.getAttribute("REQUEST_CURRENT_KEY");
        String token = jedis.get(username);
        jedis.del(username);
        jedis.del(token);
        RedisUtil.returnResource(jedis);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation("用户注册")
    @RequestMapping(value = "regist", method = RequestMethod.POST)
    public ResponseEntity<Object> regist(@RequestBody User user) {
        User user1 = userService.selectByUsername(user.getUserName());
        if(user1==null) {
            userService.regist(user);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);

        }



    }

    @ApiOperation("当前用户更改用户信息")
    @RequestMapping(value = "updateUser", method = RequestMethod.GET)
    @AuthToken
    public ResponseEntity<Object> updateUser(HttpServletRequest request,
                                             @RequestParam(required = false)String password,
                                             @RequestParam(required = false)String avater,
                                             @RequestParam(required = false)String phone) {

        String username = (String) request.getAttribute("REQUEST_CURRENT_KEY");
        String userPassword = tokenGenerator.passwordMd5(password);
        userService.updateUser(username,userPassword,avater,phone);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation("管理员添加用户")
    @RequestMapping(value = "addUser", method = RequestMethod.GET)
    @AuthToken
    public ResponseEntity<Object> addUser(HttpServletRequest request,
                                             @RequestBody User user) {

        user.setUserPassword(tokenGenerator.passwordMd5(user.getUserPassword()));
        userService.addUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation("管理员删除用户")
    @RequestMapping(value = "deleteUser", method = RequestMethod.GET)
    @AuthToken
    public ResponseEntity<Object> deleteUser(HttpServletRequest request,
                                          @RequestParam Integer userId) {


        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation("管理员赋予用户权限")
    @RequestMapping(value = "updateState", method = RequestMethod.GET)
    @AuthToken
    public ResponseEntity<Object> updateState(HttpServletRequest request,
                                             @RequestParam Integer userId,@RequestParam String role) {


        userService.updateState(userId,role);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation("管理员获取用户")
    @RequestMapping(value = "getAllUser", method = RequestMethod.POST)
    @AuthToken
    public ResponseEntity<PageInfo<User>> getAllUser(@RequestBody(required = false) Page page) {


        PageInfo<User> list=userService.getAllUser(page);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @ApiOperation("测试token接口")
    @RequestMapping(value = "test", method = RequestMethod.GET)
    @AuthToken
    public ResponseTemplate test() {
        List<User> user = userService.selectAll();
        return ResponseTemplate.builder()
                .code(200)
                .message("Success")
                .data(user)
                .build();
    }
}
