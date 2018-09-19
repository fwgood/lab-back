package com.chrome.api.controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import com.chrome.api.service.CourseService;
import com.chrome.api.service.UserService;
import com.chrome.domain.entity.Course;
import com.chrome.domain.entity.Page;
import com.chrome.domain.entity.User;
import com.chrome.infra.annotation.AuthToken;
import com.chrome.infra.interceptor.AuthorizationInterceptor;
import com.github.pagehelper.PageInfo;
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
 * Time:16:49
 */
@RestController
@Slf4j
@RequestMapping("/api/v1/course")
public class CourseController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private UserService userService;


    @ApiOperation("获取当前用户课程列表")
    @RequestMapping(value = "/courseList", method = RequestMethod.POST)
    @AuthToken
    public ResponseEntity<PageInfo<Course>> getCourseList(HttpServletRequest request, @RequestBody(required = false) Page page) {

        String username = (String) request.getAttribute(AuthorizationInterceptor.REQUEST_CURRENT_KEY);
        User user = userService.selectByUsername(username);
        if (Integer.parseInt(user.getUserRole()) != 1) {
            PageInfo<Course> list = courseService.selectCourseList(username, page);
            return new ResponseEntity<>(list, HttpStatus.OK);
        } else {
            PageInfo<Course> list = courseService.startCourse(username, page);
            return new ResponseEntity<>(list, HttpStatus.OK);
        }

    }


    @ApiOperation("学生选课课程列表")
    @RequestMapping(value = "/stateCourseList", method = RequestMethod.POST)
    @AuthToken
    public ResponseEntity<PageInfo<Course>> selectStateCourse(HttpServletRequest request, @RequestParam(required = false) String param, @RequestBody(required = false) Page page) {
        String username = (String) request.getAttribute("REQUEST_CURRENT_KEY");
        PageInfo<Course> list = courseService.selectStateCourse(param, username, page);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @ApiOperation("学生选课")
    @RequestMapping(value = "/selectCourse", method = RequestMethod.POST)
    @AuthToken
    public ResponseEntity<Object> selectCourse(HttpServletRequest request, @RequestParam String password, @RequestParam Integer courseId) {

        String username = (String) request.getAttribute("REQUEST_CURRENT_KEY");
        if (courseService.selectCourse(username, password, courseId)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @ApiOperation("学生退课")
    @RequestMapping(value = "/dropCourse", method = RequestMethod.POST)
    @AuthToken
    public ResponseEntity<Object> dropCourse(HttpServletRequest request, @RequestParam Integer courseId) {

        String username = (String) request.getAttribute("REQUEST_CURRENT_KEY");
        if (courseService.dropCourse(username, courseId)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @ApiOperation("老师申请开课")
    @RequestMapping(value = "/addCourse", method = RequestMethod.POST)
    @AuthToken
    public ResponseEntity<Object> addCourse(HttpServletRequest request, @RequestBody Course course) {

        String username = (String) request.getAttribute("REQUEST_CURRENT_KEY");
        courseService.addCourse(course, username);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @ApiOperation("管理员获取所有用户课程列表")
    @RequestMapping(value = "/allCourseList", method = RequestMethod.POST)
    @AuthToken
    public ResponseEntity<List<Course>>  selectAll() {



        List<Course> list = courseService.selectAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @ApiOperation("管理员删除课程")
    @RequestMapping(value = "/deleteCourse", method = RequestMethod.POST)
    @AuthToken
    public ResponseEntity<Object> deleteCourse(@RequestParam Integer courseId) {


        if (courseService.deleteCourse(courseId)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @ApiOperation("管理员审核课程")
    @RequestMapping(value = "/checkCourse", method = RequestMethod.POST)
    @AuthToken
    public ResponseEntity<Object> checkCourse(@RequestParam Integer courseState, @RequestParam Integer courseId) {


        if (courseService.checkCourse(courseState, courseId)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }


}
