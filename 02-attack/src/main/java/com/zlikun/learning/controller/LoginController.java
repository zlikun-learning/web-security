package com.zlikun.learning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * 这里仅用于辅助其它测试使用，所以不用考虑是否严谨、安全等
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/11/12 10:59
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(HttpSession session) {
        // 仅作演示使用，表示用户zlikun已登录
        session.setAttribute("login_user" ,"zlikun");
        return "redirect:/" ;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/" ;
    }

}
