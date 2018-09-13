package com.chrome.api.service.impl;

import java.util.List;

import com.chrome.api.service.LabService;
import com.chrome.domain.entity.Lab;
import com.chrome.domain.entity.UserLab;
import com.chrome.infra.mapper.LabMapper;
import com.chrome.infra.mapper.UserLabMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
   /* @Override
    public List<Lab> selectLabList(String username, Integer courseId) {
        return labMapper.selectLabList(username,courseId);
    }*/

    @Override
    public List<Lab> selectLabListOnCourse(Integer courseId) {
        Lab lab=new Lab();
        lab.setCourseId(courseId);
        return labMapper.select(lab);
    }

    @Override
    public List<UserLab> getScoreList(Integer labId) {
        UserLab userLab =new UserLab();
        userLab.setLabId(labId);
       return  userLabMapper.select(userLab);

    }

    @Override
    public void addLab(Lab lab) {
        labMapper.insert(lab);
    }

    @Override
    public List<Lab> getLabScoreList(String username, Integer courseId) {
       return  labMapper.getLabScoreList(username,courseId);

    }

    @Override
    public boolean addLabScore(Integer userId, Integer labId, Float score) {
        UserLab userLab =new UserLab();
        userLab.setLabId(labId);
        userLab.setUserId(userId);
        userLab.setScore(score);
        int i = userLabMapper.updateByPrimaryKeySelective(userLab);
        if(i!=1){
            return false;
        }else{
            return true;
        }
    }
}
