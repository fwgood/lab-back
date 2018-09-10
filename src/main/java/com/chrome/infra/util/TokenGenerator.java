package com.chrome.infra.util;

import org.springframework.stereotype.Component;

/**
 * Created with IDEA
 * author:Chengcong
 * Date:2018/9/8
 * Time:9:48
 */
//token生成器
@Component
public interface TokenGenerator {

    public String generate(String... strings);

}
