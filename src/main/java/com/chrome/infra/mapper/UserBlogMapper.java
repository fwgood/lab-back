package com.chrome.infra.mapper;

import com.chrome.domain.entity.UserBlog;
import com.chrome.infra.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserBlogMapper extends MyMapper<UserBlog> {
}