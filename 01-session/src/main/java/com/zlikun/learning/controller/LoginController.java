package com.zlikun.learning.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/11/11 17:17
 */
@Slf4j
@Controller
public class LoginController {

    /**
     * 跳转到登录页
     * @param session
     * @return
     */
    @GetMapping("/login")
    @CrossOrigin({ "http://i.zlikun.com" ,"http://i.zlikun.net" })  // 测试发现该注解无用(iframe)
    public ModelAndView toLogin(HttpSession session) {
        ModelAndView mav = new ModelAndView("login") ;
        // 如果登录用户不为空，则直接跳转到首页
        if (session.getAttribute("login_user") != null) {
            mav.setViewName("redirect:/");
            return mav ;
        }
        String token = UUID.randomUUID().toString() ;
        mav.addObject("token" , token) ;
        session.setAttribute("token" ,token);
        return mav ;
    }

    /**
     * 执行登录请求
     * @param session
     * @param token
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    public String doLogin(HttpSession session ,HttpServletRequest request ,
                          @RequestParam String token ,
                          @RequestParam String username ,
                          @RequestParam String password) {
        log.info("执行登录：username = {} ,password = {} ,token = {}" ,username ,password ,token);
        String serverToken = (String) session.getAttribute("token");
        if (serverToken == null || !serverToken.equals(token)) {
            // Token 校验失败，跳回登录页
            log.warn("Token值无效");
            return "redirect:/login" ;
        }
        // 仅供测试，当用户名密码一致时，即通过认证
        if (!username.equals(password)) {
            log.warn("用户名、密码不匹配");
            return "redirect:/login" ;
        }
        // 为避免`Session Fixation Attack`攻击，登录成功后应更新会话ID
        // 通过重新创建SESSION的方式强制更新会话ID
        session.invalidate();
        session = request.getSession(true) ;
        // 记录用户认证信息
        session.setAttribute("login_user" ,username);
        return "redirect:/" ;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/" ;
    }

}
