package com.chrome;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Created with IDEA
 * author:Chengcong
 * Date:2018/9/8
 * Time:9:48
 */
//测试环境
/*@SpringBootApplication
public class ExperimentApplication {


    public static void main(String[] args) {
        SpringApplication.run(ExperimentApplication.class, args);
    }
}*/
//开发环境配置
@SpringBootApplication
public class ExperimentApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ExperimentApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ExperimentApplication.class, args);
    }
}

