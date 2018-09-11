package com.chrome.api.controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.chrome.api.dto.LoginDto;
import com.chrome.api.dto.ResponseTemplate;
import com.chrome.api.service.UserService;
import com.chrome.domain.entity.User;
import com.chrome.infra.annotation.AuthToken;
import com.chrome.infra.util.ConstantKit;
import com.chrome.infra.util.Md5TokenGenerator;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
    Jedis jedis = new Jedis("localhost", 6379);


    @Autowired
    Md5TokenGenerator tokenGenerator;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ApiOperation("用户登录接口")
    public ResponseEntity<JSONObject> login(@RequestBody(required = false) LoginDto loginDto) {

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
            jedis.close();
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
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @AuthToken
    public ResponseEntity<JSONObject> getCurrentUser(HttpServletRequest request) {


        JSONObject result = new JSONObject();
        String username = (String) request.getAttribute("REQUEST_CURRENT_KEY");
        User user = userService.selectByUsername(username);
        result.put("user",user);
        return new ResponseEntity<>(result,HttpStatus.OK);
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
