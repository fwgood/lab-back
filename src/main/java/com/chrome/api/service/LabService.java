package com.chrome.api.service;

import java.util.List;

import com.chrome.api.dto.CommitLabDto;
import com.chrome.domain.entity.Lab;
import com.chrome.domain.entity.Page;
import com.chrome.domain.entity.UserLab;
import com.github.pagehelper.PageInfo;

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

    PageInfo<UserLab> getScoreList(Integer labId, Page page);

    void addLab(Lab lab);

    List<Lab> getLabScoreList(String username, Integer courseId);

    boolean addLabScore(Integer userId, Integer labId, Float score);

    List<Lab> getLabList(Integer courseId);


    void labCommit(String username, CommitLabDto commitLabDto);
}
