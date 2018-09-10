package com.chrome.infra.mapper;

import com.chrome.domain.entity.UserBlogreview;
import com.chrome.infra.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserBlogreviewMapper extends MyMapper<UserBlogreview> {
}