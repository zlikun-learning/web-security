package com.zlikun.learning.input;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * 测试部分输入校验的方法
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/11/12 10:34
 */
public class InputValidateTest {

    @Test
    public void regex() {

        // 校验手机号(大陆)，仅供测试，不一定全
        assertTrue("15600000001".matches("^1[345789]\\d{9}$")) ;

        // 校验邮箱(邮箱随便写的，仅为了演示复杂邮箱格式)
        assertTrue("zlikun.dev@cn-domain.com.cn".matches("^[a-zA-Z0-9-_\\.]+@[a-zA-Z0-9_-]+\\.[a-zA-Z]+(\\.[a-zA-Z]+)*$"));

    }

}
