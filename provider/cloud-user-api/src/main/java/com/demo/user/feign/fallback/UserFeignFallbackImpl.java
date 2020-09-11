package com.demo.user.feign.fallback;

import com.demo.user.feign.UserFeignClient;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 描述：
 *
 * @author caojing
 * @create 2020-09-08-9:38
 */

@Slf4j
@Component
public class UserFeignFallbackImpl implements UserFeignClient {

    @Setter
    private Throwable cause;

    public String helloWorld() {
        log.error("feign调用失败：", cause);
        return "报异常了";
    }
}
