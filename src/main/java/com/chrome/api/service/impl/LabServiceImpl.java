package com.chrome.api.service.impl;

import java.util.List;

import com.chrome.api.dto.CommitLabDto;
import com.chrome.api.service.LabService;
import com.chrome.api.service.UserService;
import com.chrome.domain.entity.Lab;
import com.chrome.domain.entity.Page;
import com.chrome.domain.entity.Selectcourse;
import com.chrome.domain.entity.UserLab;
import com.chrome.infra.globalexception.CommonException;
import com.chrome.infra.mapper.LabMapper;
import com.chrome.infra.mapper.SelectcourseMapper;
import com.chrome.infra.mapper.UserLabMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IDEA
 * author:Chengcong
 * Date:2018/9/11
 * Time:19:37
 */
@Service
public class LabServiceImpl implements LabService {
    @Autowired
    private LabMapper labMapper;
    @Autowired
    private UserLabMapper userLabMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private SelectcourseMapper selectcourseMapper;
   /* @Override
    public List<Lab> selectLabList(String username, Integer courseId) {
        return labMapper.selectLabList(username,courseId);
    }*/

    @Override
    public List<Lab> selectLabListOnCourse(Integer courseId) {
        Lab lab = new Lab();
        lab.setCourseId(courseId);
        return labMapper.select(lab);
    }

    @Override
    public PageInfo<UserLab> getScoreList(Integer labId, Page page) {
        UserLab userLab = new UserLab();
        userLab.setLabId(labId);
        PageHelper.startPage(page.getPage(), page.getPageSize(), "id " + page.getSort());
        return new PageInfo<>(userLabMapper.select(userLab));

    }

    @Override
    @Transactional
    public void addLab(Lab lab) {
        Integer courseId = lab.getCourseId();
        Selectcourse selectcourse =new Selectcourse();
        selectcourse.setCourseId(courseId);
        List<Selectcourse> select = selectcourseMapper.select(selectcourse);

        int insert = labMapper.insert(lab);
        if (insert != 1) {
            throw new CommonException("error.Lab.create");
        }
    Integer labId=labMapper.getLastInsertId();
        Lab lab1 = labMapper.selectByPrimaryKey(labId);

        for(int i=0;i<select.size();i++){
            UserLab userLab =new UserLab();
            userLab.setLabId(labId);
            userLab.setUserId(select.get(i).getUserId());
            userLab.setLabName(lab1.getLabName());
            userLab.setUserName(select.get(i).getUserName());
            userLab.setCourseId(courseId);
            userLabMapper.insertSelective(userLab);
        }

    }

    @Override
    public List<Lab> getLabScoreList(String username, Integer courseId) {
        return labMapper.getLabScoreList(username, courseId);

    }

    @Override
    @Transactional
    public boolean addLabScore(Integer userId, Integer labId, Float score) {
        UserLab userLab = new UserLab();
        userLab.setLabId(labId);
        userLab.setUserId(userId);
        UserLab userLab1 = userLabMapper.selectOne(userLab);
        userLab1.setScore(score);
        int i = userLabMapper.updateByPrimaryKeySelective(userLab1);
        if (i != 1) {
            throw new CommonException("error.UserLab.update");
        }
        if (i != 1) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public List<Lab> getLabList(Integer courseId) {
        Lab lab = new Lab();
        lab.setCourseId(courseId);

        return labMapper.select(lab);

    }

    @Override
    public void labCommit(String username, CommitLabDto commitLabDto) {
        UserLab userLab = new UserLab();
        userLab.setUserName(username);
        userLab.setLabId(commitLabDto.getLabId());
        UserLab userLab1 = userLabMapper.selectOne(userLab);
        userLab1.setCommitUrl(commitLabDto.getCommitUrl());
        userLab1.setCommitContent(commitLabDto.getCommitContent());
        int i = userLabMapper.updateByPrimaryKeySelective(userLab1);
        if (i != 1) {
            throw new CommonException("error.UserLab.update");
        }

    }
}
