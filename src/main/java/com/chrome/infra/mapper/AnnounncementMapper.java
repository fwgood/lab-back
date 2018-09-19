package com.chrome.infra.mapper;

import java.util.List;

import com.chrome.api.dto.AnnoIsReadDto;
import com.chrome.domain.entity.Announncement;
import com.chrome.infra.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface AnnounncementMapper extends MyMapper<Announncement> {
    List<Announncement> getAnnoList(@Param("username") String username);

    List<AnnoIsReadDto> getAnnoAllList(@Param("userId") Integer userId);
}