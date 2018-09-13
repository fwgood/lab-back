package com.chrome.api.controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import com.chrome.api.service.LabService;
import com.chrome.domain.entity.Lab;
import com.chrome.domain.entity.UserLab;
import com.chrome.infra.annotation.AuthToken;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

   /* @ApiOperation("学生获取当前用户某课程下实验列表")
    @RequestMapping(value = "/labList", method = RequestMethod.GET)
    @AuthToken
    public ResponseEntity<List<Lab>> getCourseList(HttpServletRequest request, @RequestParam Integer courseId) {

        String username = (String) request.getAttribute("REQUEST_CURRENT_KEY");
        List<Lab> list= labService.selectLabList(username,courseId);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }*/

    @ApiOperation("老师获取当前实验下的所有学生成绩信息")
    @RequestMapping(value = "/scoreList", method = RequestMethod.GET)
    @AuthToken
    public ResponseEntity<List<UserLab>> getScoreList(@RequestParam Integer labId) {
        List<UserLab> list= labService.getScoreList(labId);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @ApiOperation("老师在选中课程下添加实验")
    @RequestMapping(value = "/addLab", method = RequestMethod.POST)
    @AuthToken
    public ResponseEntity<List<UserLab>> addLab(@RequestBody Lab lab) {
        labService.addLab(lab);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation("学生获取当前用户某课程下实验及成绩列表")
    @RequestMapping(value = "/labScoreList", method = RequestMethod.GET)
    @AuthToken
    public ResponseEntity<List<Lab>> getLabScoreList(HttpServletRequest request, @RequestParam Integer courseId) {

        String username = (String) request.getAttribute("REQUEST_CURRENT_KEY");
        List<Lab> list= labService.getLabScoreList(username,courseId);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }


}
