package com.chrome.api.service.impl;

import java.util.List;

import com.chrome.api.service.LabService;
import com.chrome.domain.entity.Lab;
import com.chrome.infra.mapper.LabMapper;
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
    @Override
    public List<Lab> selectLabList(String username, Integer courseId) {
        return labMapper.selectLabList(username,courseId);
    }

    @Override
    public List<Lab> selectLabListOnCourse( Integer courseId) {
        Lab lab=new Lab();
        lab.setCourseId(courseId);
        return labMapper.select(lab);
    }
}
