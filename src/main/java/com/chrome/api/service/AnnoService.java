package com.chrome.api.service;

import java.util.List;

import com.chrome.domain.entity.Announncement;

/**
 * Created with IDEA
 * author:Chengcong
 * Date:2018/9/14
 * Time:9:46
 */
public interface AnnoService {
    List<Announncement> getAnnoList(String username);

    void publishAnno(String username, Announncement announncement);
}
