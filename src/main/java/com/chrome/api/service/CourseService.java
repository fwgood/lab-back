package com.chrome.api.service;

import java.util.List;

import com.chrome.domain.entity.Course;

/**
 * Created with IDEA
 * author:Chengcong
 * Date:2018/9/11
 * Time:16:56
 */
public interface CourseService {

    List<Course> selectCourseList(String username);


    void addCourse(Course course,String username);

    List<Course> selectAll();

    Boolean selectCourse(String username, String password,Integer courseId);

    List<Course> selectStateCourse();

    boolean deleteCourse(Integer courseState, Integer courseId);
}
