package com.chrome.api.controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import com.chrome.api.service.LabService;
import com.chrome.domain.entity.Lab;
import com.chrome.infra.annotation.AuthToken;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IDEA
 * author:Chengcong
 * Date:2018/9/11
 * Time:19:36
 */
@RestController
@Slf4j
@RequestMapping("/api/v1/lab")
public class LabController {

    @Autowired
    private LabService labService;

    @ApiOperation("获取当前用户某课程下实验列表")
    @RequestMapping(value = "/labList", method = RequestMethod.GET)
    @AuthToken
    public ResponseEntity<List<Lab>> getCourseList(HttpServletRequest request, @RequestParam Integer courseId) {

        String username = (String) request.getAttribute("REQUEST_CURRENT_KEY");
        List<Lab> list= labService.selectLabList(username,courseId);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }



}
