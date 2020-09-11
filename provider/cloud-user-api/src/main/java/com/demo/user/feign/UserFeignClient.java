package com.demo.user.feign;

import com.demo.user.feign.factory.UserFeignFallbackFactory;
import com.demo.user.feign.fallback.UserFeignFallbackImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 描述：
 *
 * @author caojing
 * @create 2020-09-04-14:05
 */
@FeignClient(value = "service-provider", /**fallback = UserFeignFallbackImpl.class **/
        fallbackFactory = UserFeignFallbackFactory.class)
public interface UserFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    String helloWorld();
}
