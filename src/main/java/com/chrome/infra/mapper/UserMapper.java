package com.chrome.infra.mapper;

import com.chrome.domain.entity.User;
import com.chrome.infra.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper extends MyMapper<User> {
    String getRole(String username);
}