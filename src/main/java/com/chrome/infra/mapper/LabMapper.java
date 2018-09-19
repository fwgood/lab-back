package com.chrome.infra.mapper;

import java.util.List;

import com.chrome.domain.entity.Lab;
import com.chrome.infra.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface LabMapper extends MyMapper<Lab> {
    List<Lab> getLabScoreList(@Param("username") String username, @Param("courseId") Integer courseId);

    Integer getLastInsertId();
}