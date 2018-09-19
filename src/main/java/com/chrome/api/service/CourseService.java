package com.chrome.api.service;

import java.util.List;

import com.chrome.domain.entity.Course;
import com.chrome.domain.entity.Page;
import com.github.pagehelper.PageInfo;

/**
 * Created with IDEA
 * author:Chengcong
 * Date:2018/9/11
 * Time:16:56
 */
public interface CourseService {

    PageInfo<Course> selectCourseList(String username, Page page);


    void addCourse(Course course, String username);

    List<Course> selectAll();

    Boolean selectCourse(String username, String password, Integer courseId);

    PageInfo<Course> selectStateCourse(String param, String username, Page page);

    boolean deleteCourse(Integer courseId);

    boolean checkCourse(Integer courseState, Integer courseId);

    boolean dropCourse(String username, Integer courseId);

    PageInfo<Course> startCourse(String username, Page page);
}
