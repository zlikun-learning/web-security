package com.zlikun.learning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017-11-09 15:28
 */
@Controller
public class DefaultController {

    @GetMapping("/")
    public String index() {
        return "index" ;
    }

}
