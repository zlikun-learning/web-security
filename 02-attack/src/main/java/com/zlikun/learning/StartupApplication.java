package com.zlikun.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017-11-12 10:50
 */
@SpringBootApplication
@EnableWebMvc
public class StartupApplication {

    public static void main(String[] args) {

        SpringApplication.run(StartupApplication.class ,args) ;

    }

}
