package com.cj.auth.controller;

import org.springframework.security.core.authority.AuthorityUtils;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述：
 *
 * @author caojing
 * @create 2020-09-10-10:07
 */
@Controller
public class IndexController {
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    private String hello() {
        return "123";
    }

//    @RequestMapping("/user")
//    @ResponseBody
//    public Map<String, Object> user(OAuth2Authentication user) {
//        Map<String, Object> userInfo = new HashMap<String, Object>();
//        userInfo.put("user", user.getUserAuthentication().getPrincipal());
//        userInfo.put("authorities", AuthorityUtils.authorityListToSet(
//                user.getUserAuthentication().getAuthorities()
//        ));
//        return userInfo;
//    }
}
