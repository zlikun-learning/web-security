package com.zlikun.learning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * XSS (Cross-Site Scripting) ，跨站脚本
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/11/12 10:53
 */
@Controller
public class XSSController {

    /**
     * 用于演示XSS效果
     * @param keyword
     * @return
     */
    @RequestMapping(path = "/search" ,method = { RequestMethod.GET ,RequestMethod.POST })
    public ModelAndView search(String keyword) {
        ModelAndView mav = new ModelAndView("search") ;
        // 由于输入信息被原封不动返回给前端，造成脚本可以在前端运行，从而导致XSS攻击
        mav.addObject("keyword" ,keyword) ;
        return mav ;
    }

    /**
     * 该请求表示一个钓鱼请求，内嵌iframe将会获取被钓鱼用户的用户信息
     * @return
     */
    @GetMapping("/xss")
    public String xss() {
        return "xss" ;
    }

    @GetMapping("/trap")
    public String trap(ModelMap model ,String message) {
        model.put("message" ,message) ;
        return "trap" ;
    }

}
