package com.chrome.api.service.impl;

import java.util.List;

import com.chrome.api.dto.AnnoIsReadDto;
import com.chrome.api.service.AnnoService;
import com.chrome.api.service.UserService;
import com.chrome.domain.entity.*;
import com.chrome.infra.globalexception.CommonException;
import com.chrome.infra.mapper.AnnounncementMapper;
import com.chrome.infra.mapper.LabMapper;
import com.chrome.infra.mapper.SelectcourseMapper;
import com.chrome.infra.mapper.UserAnnounncementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IDEA
 * author:Chengcong
 * Date:2018/9/14
 * Time:9:45
 */
@Service
public class AnnoServiceImpl implements AnnoService {
    @Autowired
    private AnnounncementMapper announncementMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private LabMapper labMapper ;
    @Autowired
    private SelectcourseMapper selectcourseMapper;
    @Autowired
    private UserAnnounncementMapper userAnnounncementMapper;

    @Override
    public List<Announncement> getAnnoList(String username) {
        return announncementMapper.getAnnoList(username);
    }

    @Override
    @Transactional
    public void publishAnno(String username, Announncement announncement) {
        User user = userService.selectByUsername(username);
        Integer courseId = announncement.getAnnounncementCourseId();
        Selectcourse selectcourse =new Selectcourse();
        selectcourse.setCourseId(courseId);
        List<Selectcourse> select = selectcourseMapper.select(selectcourse);
        announncement.setAnnounncementUserId(user.getUserId());
        int insert = announncementMapper.insert(announncement);
        if (insert != 1) {
            throw new CommonException("error.Anno.create");
        }
        Integer lastInsertId = labMapper.getLastInsertId();

        for(int i=0;i<select.size();i++){
            UserAnnounncement userAnnounncement =new UserAnnounncement();
            userAnnounncement.setAnnounncementId(lastInsertId);
            userAnnounncement.setUserId(select.get(i).getUserId());
            userAnnounncementMapper.insertSelective(userAnnounncement);
        }

    }

    @Override
    public List<AnnoIsReadDto> getAnnoAllList(String username) {
        User user = userService.selectByUsername(username);
        announncementMapper.getAnnoAllList(user.getUserId());

        return null;
    }

    @Override
    public void updateIsRead(Integer id) {
        UserAnnounncement userAnnounncement = userAnnounncementMapper.selectByPrimaryKey(id);
        userAnnounncement.setIsRead("1");
        int i = userAnnounncementMapper.updateByPrimaryKeySelective(userAnnounncement);
        if(i!=1){
            throw new CommonException("error.update.userAnnounncement");
        }

    }
}
