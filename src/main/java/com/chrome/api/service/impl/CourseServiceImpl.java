package com.chrome.api.service.impl;

import java.util.List;

import com.chrome.api.service.CourseService;
import com.chrome.api.service.LabService;
import com.chrome.api.service.UserService;
import com.chrome.domain.entity.*;
import com.chrome.infra.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IDEA
 * author:Chengcong
 * Date:2018/9/11
 * Time:16:57
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private SelectcourseMapper selectcourseMapper;

    @Autowired
    private LabService labService;
    @Autowired
    private LabMapper labMapper;
    @Autowired
    private UserLabMapper userLabMapper;
    @Autowired
    private StartcourseMapper startcourseMapper;

    @Override
    public List<Course> selectAll() {
        return courseMapper.selectAll();
    }

    @Override
    public void addCourse(Course course,String username) {
        User user =userService.selectByUsername(username);
        course.setUserId(user.getUserId());
        course.setUserName(user.getUserName());
        courseMapper.insert(course);

    }

    @Override
    public List<Course> selectCourseList(String username) {

         return courseMapper.selectCourseList(username);

    }

    @Override
    public Boolean selectCourse(String username, String password,Integer courseId) {
        User user =userService.selectByUsername(username);
        Selectcourse selectcourse=new Selectcourse();
        selectcourse.setUserName(user.getUserName());
        selectcourse.setUserId(user.getUserId());
        selectcourse.setCourseId(courseId);
        Course course = courseMapper.selectByPrimaryKey(courseId);
        selectcourse.setCourseName(course.getCourseName());

        if(course.getCoursePassword().equals(password)) {
            UserLab userLab;
            selectcourseMapper.insert(selectcourse);
            List<Lab> labs = labService.selectLabListOnCourse(courseId);
            for (Lab l:labs) {
                userLab =new UserLab();
                userLab.setUserId(user.getUserId());
                userLab.setUserName(user.getUserName());
                userLab.setLabId(l.getLabId());
                userLab.setLabName(l.getLabName());
                userLab.setCourseId(courseId);
                int insert = userLabMapper.insert(userLab);
                System.out.println("插入了"+insert+"数据");
            }
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<Course> selectStateCourse(String param, String username) {
       return courseMapper.selectStateCourse(param,username);

    }

    @Override
    public boolean checkCourse(Integer courseState, Integer courseId) {
        Course course=new Course();
        course.setCourseId(courseId);
        course.setCourseState(courseState);

        int i = courseMapper.updateByPrimaryKeySelective(course);
        return i==1?true:false;
    }

    @Override
    public boolean dropCourse(String username, Integer courseId) {


            Selectcourse selectcourse =new Selectcourse();
            selectcourse.setCourseId(courseId);
            selectcourse.setUserName(username);
        int delete = selectcourseMapper.delete(selectcourse);

        UserLab userLab=new UserLab();
            userLab.setCourseId(courseId);
            userLab.setUserName(username);
            userLabMapper.delete(userLab);
        return delete==1?true:false;

    }

    @Override
    public boolean deleteCourse(Integer courseState, Integer courseId) {
        if(courseState==0){
            int i = courseMapper.deleteByPrimaryKey(courseId);
            return i==1?true:false;

        }else{
            int i = courseMapper.deleteByPrimaryKey(courseId);
            Lab lab=new Lab();
            lab.setCourseId(courseId);
            labMapper.delete(lab);
            Selectcourse selectcourse =new Selectcourse();
            selectcourse.setCourseId(courseId);
            selectcourseMapper.delete(selectcourse);
            /*Startcourse startcourse =new Startcourse();
            startcourse.setCourseId(courseId);
            startcourseMapper.delete(startcourse);*/
            UserLab userLab=new UserLab();
            userLab.setCourseId(courseId);
            userLabMapper.delete(userLab);


            return i==1?true:false;

        }

    }

    @Override
    public List<Course> startCourse(String username) {
        Course course =new Course();
        course.setUserName(username);
      return   courseMapper.select(course);
    }
}
