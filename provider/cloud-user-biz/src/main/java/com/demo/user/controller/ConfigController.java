package com.demo.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：
 *
 * @author caojing
 * @create 2020-09-04-10:49
 */
@RestController
public class ConfigController {
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public String get() throws Exception {
//        throw  new Exception("出错啦");
        return "hello world";
    }
}
