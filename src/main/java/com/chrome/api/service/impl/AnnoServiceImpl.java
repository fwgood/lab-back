package com.chrome.api.service.impl;

import java.util.List;

import com.chrome.api.service.AnnoService;
import com.chrome.domain.entity.Announncement;
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
    @Override
    public List<Announncement> getAnnoList(String username) {
        return announncementMapper.getAnnoList(username);
    }
}
