package com.chrome.api.service;

import java.util.List;

import com.chrome.domain.entity.Lab;
import com.chrome.domain.entity.UserLab;

/**
 * Created with IDEA
 * author:Chengcong
 * Date:2018/9/11
 * Time:19:37
 */
public interface LabService {


    /*List<Lab> selectLabList(String username, Integer courseId);
*/
    List<Lab> selectLabListOnCourse(Integer courseId);

    List<UserLab> getScoreList(Integer labId);

    void addLab(Lab lab);

    List<Lab> getLabScoreList(String username, Integer courseId);
}
