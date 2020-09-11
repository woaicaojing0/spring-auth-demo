package com.demo.user.feign.factory;

import com.demo.user.feign.UserFeignClient;
import com.demo.user.feign.fallback.UserFeignFallbackImpl;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 描述：
 *
 * @author caojing
 * @create 2020-09-08-16:18
 */
@Component
public class UserFeignFallbackFactory implements FallbackFactory<UserFeignClient> {
    public UserFeignClient create(Throwable throwable) {
        // 日志最好放在各个fallback方法中，而不要直接放在create方法中。
        // 否则在引用启动时，就会打印该日志。
        // 详见https://github.com/spring-cloud/spring-cloud-netflix/issues/1471
        UserFeignFallbackImpl userFeignFallbackImpl = new UserFeignFallbackImpl();
        userFeignFallbackImpl.setCause(throwable);
        return userFeignFallbackImpl;
    }
}
