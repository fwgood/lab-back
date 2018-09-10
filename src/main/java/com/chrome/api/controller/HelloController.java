package com.chrome.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * Created with IDEA
 * author:Chengcong
 * Date:2018/9/8
 * Time:9:48
 */
@RequestMapping("/a")
@RestController
public class HelloController {

    @GetMapping("/helloworld")
    public void hello() {
        System.out.println(1);
    }
}
