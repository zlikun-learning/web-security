package com.zlikun.learning.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;

/**
 * 测试HTTP认证
 *
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/11/11 16:35
 */
@Slf4j
@RestController
public class AuthenticateController {

    @GetMapping(path = "/auth/basic")
    public Object auth_by_basic(HttpServletRequest request ,HttpServletResponse response) {
        log.info("使用BASIC认证");

        // 强制不使用客户端缓存
        response.setHeader("Cache-Control", "no-store");
        response.setDateHeader("Expires", 0);

        // 判断请求消息头中是否包含了Authenticate信息
        String auth = request.getHeader("Authorization") ;
        if (auth == null) {
            // 强制返回401状态码，要求使用BASIC认证
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setHeader("WWW-Authenticate" ,"Basic realm=\"i.zlikun.com\"");
            return "require login ." ;
        }

        // 删除Basic 几个字符
        auth = auth.substring(6) ;

        log.info("Authentication Header : {}" ,auth);

        // 使用Base64解码
        String info = new String(Base64.getDecoder().decode(auth)) ;

        // 仅供测试
        return "login success ,login info : " + info;
    }


}
