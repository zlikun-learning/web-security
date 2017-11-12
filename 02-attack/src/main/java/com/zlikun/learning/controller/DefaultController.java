package com.zlikun.learning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017-11-12 10:50
 */
@Controller
public class DefaultController {

    @GetMapping("/")
    public String index(HttpServletResponse response) {
        // 这里强制写入Cookie信息，用于配置测试XSS攻击
        response.addCookie(new Cookie("author" ,"zlikun"));
        return "index" ;
    }

}
