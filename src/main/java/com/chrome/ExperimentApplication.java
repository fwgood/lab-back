package com.chrome;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created with IDEA
 * author:Chengcong
 * Date:2018/9/8
 * Time:9:48
 */
@SpringBootApplication
public class ExperimentApplication {


    public static void main(String[] args) {
        SpringApplication.run(ExperimentApplication.class, args);
    }
}
//开发环境配置
/*@SpringBootApplication
public class ExperimentApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ExperimentApplication.class);
    }
>>>>>>> Stashed changes

    public static void main(String[] args) {
        SpringApplication.run(ExperimentApplication.class, args);
    }
}*/

