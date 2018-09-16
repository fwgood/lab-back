package com.chrome.infra.mapper;

import java.util.List;

import com.chrome.domain.entity.Blogsreview;
import com.chrome.infra.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface BlogsreviewMapper extends MyMapper<Blogsreview> {
    List<Blogsreview> getComments(Integer parentId);
}