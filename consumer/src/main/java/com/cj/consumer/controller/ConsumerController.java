package com.cj.consumer.controller;

import com.demo.user.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：
 *
 * @author caojing
 * @create 2020-09-04-14:07
 */
@RestController
public class ConsumerController {

    @Autowired
    private UserFeignClient providerClient;

    @RequestMapping(value = "/hello-consumer", method = RequestMethod.GET)
    public String hello() {
//        String result = providerClient.helloWrold();
//        System.out.println(result);
        return "123";
    }

    @RequestMapping(value = "/hello-provide", method = RequestMethod.GET)
    public String helloProvide() {
//        String result = providerClient.helloWrold();
//        System.out.println(result);
        return providerClient.helloWorld();
    }
}
