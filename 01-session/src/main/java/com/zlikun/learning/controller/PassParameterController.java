package com.zlikun.learning.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 测试请求参数传递
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/11/11 15:56
 */
@Slf4j
@RestController
public class PassParameterController {

    /**
     * POST http://i.zlikun.com/receive
     * @param request
     * @return
     */
    @PostMapping(path = "/receive")
    public Object receiveParameters(HttpServletRequest request) {

        // 遍历输出请求参数
        request.getParameterMap().entrySet().stream()
                .forEach(entry -> {
                    log.info("request parameter name = {} ,value = {}" ,entry.getKey() , Arrays.toString(entry.getValue()));
                });

        // 将请求参数组装成Map，返回到前端
        return request.getParameterMap().entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey , Map.Entry::getValue)) ;
    }

}
