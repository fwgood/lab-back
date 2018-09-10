package com.chrome.infra.util;

import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

/**
 * Created with IDEA
 * author:Chengcong
 * Date:2018/9/8
 * Time:9:48
 */
@Component
public class Md5TokenGenerator implements TokenGenerator {

    @Override
    public String generate(String... strings) {
        long   timestamp = System.currentTimeMillis();
        String tokenMeta = "";
        for (String s : strings) {
            tokenMeta = tokenMeta + s;
        }
        tokenMeta = tokenMeta + timestamp;
        String token = DigestUtils.md5DigestAsHex(tokenMeta.getBytes());
        return token;
    }

  public String passwordMd5(String password){
        return DigestUtils.md5DigestAsHex(password.getBytes());
  }

    public static void main(String[] args) {
        System.out.println(new Md5TokenGenerator().passwordMd5("cc"));
    }
}
