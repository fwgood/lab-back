package com.chrome.infra.mapper;

import com.chrome.domain.entity.UserLab;
import com.chrome.infra.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserLabMapper extends MyMapper<UserLab> {
}