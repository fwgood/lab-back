package com.chrome.infra.mapper;

import java.util.List;

import com.chrome.domain.entity.UserLab;
import com.chrome.infra.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserLabMapper extends MyMapper<UserLab> {
    List<UserLab> selectLabList(@Param("username") String username,@Param("courseId") Integer courseId);
}