package com.chrome.api.controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import com.chrome.api.service.AnnoService;
import com.chrome.domain.entity.Announncement;
import com.chrome.infra.annotation.AuthToken;
import com.chrome.infra.interceptor.AuthorizationInterceptor;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IDEA
 * author:Chengcong
 * Date:2018/9/14
 * Time:9:45
 */
@RestController
@Slf4j
@RequestMapping("/api/v1/anno")
public class AnnoController {

    @Autowired
    private AnnoService annoService;




    @ApiOperation("查询公告")
    @RequestMapping(value = "/annoList", method = RequestMethod.GET)
    @AuthToken
    public ResponseEntity<List<Announncement>> getAnnoList(HttpServletRequest request) {

        String username = (String) request.getAttribute(AuthorizationInterceptor.REQUEST_CURRENT_KEY);
        List<Announncement> list= annoService.getAnnoList(username);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @ApiOperation("发布公告")
    @RequestMapping(value = "/publishAnno", method = RequestMethod.POST)
    @AuthToken
    public ResponseEntity<Object> publishAnno(HttpServletRequest request, @RequestBody Announncement announncement) {

        String username = (String) request.getAttribute(AuthorizationInterceptor.REQUEST_CURRENT_KEY);
      annoService.publishAnno(username,announncement);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
