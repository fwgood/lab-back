package com.chrome.api.service;

import java.util.List;

import com.chrome.domain.entity.Lab;

/**
 * Created with IDEA
 * author:Chengcong
 * Date:2018/9/11
 * Time:19:37
 */
public interface LabService {


    List<Lab> selectLabList(String username, Integer courseId);

    List<Lab> selectLabListOnCourse(Integer courseId);
}
