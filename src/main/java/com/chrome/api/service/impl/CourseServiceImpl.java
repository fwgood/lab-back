package com.chrome.api.service.impl;

import java.util.List;

import com.chrome.api.service.CourseService;
import com.chrome.api.service.LabService;
import com.chrome.api.service.UserService;
import com.chrome.domain.entity.*;
import com.chrome.infra.globalexception.CommonException;
import com.chrome.infra.mapper.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


    @Override
    public List<Course> selectAll() {
        return courseMapper.selectAll();
    }

    @Override
    public void addCourse(Course course, String username) {
        User user = userService.selectByUsername(username);
        course.setUserId(user.getUserId());
        course.setUserName(user.getUserName());
        int insert = courseMapper.insert(course);
        if (insert != 1) {
            throw new CommonException("error.Course.create");
        }

    }

    @Override
    public PageInfo<Course> selectCourseList(String username, Page page) {
        PageHelper.startPage(page.getPage(), page.getPageSize(), "course_id " + page.getSort());
        return new PageInfo<>(courseMapper.selectCourseList(username));

    }

    @Override
    @Transactional
    public Boolean selectCourse(String username, String password, Integer courseId) {
        User user = userService.selectByUsername(username);
        Selectcourse selectcourse = new Selectcourse();
        selectcourse.setUserName(user.getUserName());
        selectcourse.setUserId(user.getUserId());
        selectcourse.setCourseId(courseId);
        Course course = courseMapper.selectByPrimaryKey(courseId);
        selectcourse.setCourseName(course.getCourseName());

        if (course.getCoursePassword().equals(password)) {
            UserLab userLab;
            int insert1 = selectcourseMapper.insert(selectcourse);
            if (insert1 != 1) {
                throw new CommonException("error.Selectcourse.create");
            }
            List<Lab> labs = labService.selectLabListOnCourse(courseId);
            for (Lab l : labs) {
                userLab = new UserLab();
                userLab.setUserId(user.getUserId());
                userLab.setUserName(user.getUserName());
                userLab.setLabId(l.getLabId());
                userLab.setLabName(l.getLabName());
                userLab.setCourseId(courseId);
                int insert = userLabMapper.insert(userLab);
                if (insert != 1) {
                    throw new CommonException("error.UserLab.create");
                }
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public PageInfo<Course> selectStateCourse(String param, String username, Page page) {
        PageHelper.startPage(page.getPage(), page.getPageSize(), "course_id " + page.getSort());
        return new PageInfo<>(courseMapper.selectStateCourse(param, username));


    }

    @Override
    @Transactional
    public boolean checkCourse(Integer courseState, Integer courseId) {
        Course course = new Course();
        course.setCourseId(courseId);
        course.setCourseState(courseState);

        int i = courseMapper.updateByPrimaryKeySelective(course);
        if (i != 1) {
            throw new CommonException("error.Course.update");
        }
        return i == 1 ? true : false;
    }

    @Override
    @Transactional
    public boolean dropCourse(String username, Integer courseId) {


        Selectcourse selectcourse = new Selectcourse();
        selectcourse.setCourseId(courseId);
        selectcourse.setUserName(username);
        int delete = selectcourseMapper.delete(selectcourse);
        if (delete != 1) {
            throw new CommonException("error.Selectcourse.delete");
        }

        return delete == 1 ? true : false;

    }

    @Override
    @Transactional
    public boolean deleteCourse(Integer courseId) {

        int i = courseMapper.deleteByPrimaryKey(courseId);
        if (i != 1) {
            throw new CommonException("error.Course.delete");
        }
        return true;

    }

    @Override
    public PageInfo<Course> startCourse(String username, Page page) {
        PageHelper.startPage(page.getPage(), page.getPageSize(), "course_id " + page.getSort());
        Course course = new Course();
        course.setUserName(username);
        return new PageInfo<>(courseMapper.select(course));
    }
}
