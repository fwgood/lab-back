package com.chrome.api.service.impl;

import java.util.List;

import com.chrome.api.service.AnnoService;
import com.chrome.api.service.UserService;
import com.chrome.domain.entity.Announncement;
import com.chrome.domain.entity.User;
import com.chrome.infra.globalexception.CommonException;
import com.chrome.infra.mapper.AnnounncementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IDEA
 * author:Chengcong
 * Date:2018/9/14
 * Time:9:45
 */
@Service
public class AnnoServiceImpl implements AnnoService {
    @Autowired
    private AnnounncementMapper announncementMapper ;
    @Autowired
    private UserService userService;
    @Override
    public List<Announncement> getAnnoList(String username) {
        return announncementMapper.getAnnoList(username);
    }

    @Override
    public void publishAnno(String username, Announncement announncement) {
        User user = userService.selectByUsername(username);
        announncement.setAnnounncementUserId(user.getUserId());
        int insert = announncementMapper.insert(announncement);
        if(insert!=1){
            throw new CommonException("error.Anno.create");
        }
    }
}
