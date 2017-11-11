package com.zlikun.learning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 测试 iframe 同源策略
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/11/11 18:09
 */
@Controller
public class IFrameController {

    /**
     * iframe 宿主页
     * 通过点击宿主页上的按钮可以获取iframe中元素信息
     * @return
     */
    @GetMapping("/host-page")
    public String hostPage() {

        return "host-page" ;
    }

}
