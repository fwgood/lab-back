package com.chrome.infra.mapper;

import java.util.List;

import com.chrome.domain.entity.Course;
import com.chrome.infra.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface CourseMapper extends MyMapper<Course> {
    List<Course> selectCourseList(@Param("username")String username);

    List<Course> selectStateCourse(@Param("param") String param, @Param("username") String username);
}