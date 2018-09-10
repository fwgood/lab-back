package com.chrome.infra.mapper;

import com.chrome.domain.entity.UserNews;
import com.chrome.infra.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserNewsMapper extends MyMapper<UserNews> {
}