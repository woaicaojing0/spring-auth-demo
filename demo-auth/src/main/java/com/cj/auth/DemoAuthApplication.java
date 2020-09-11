package com.cj.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * 1.该注解将当前应用作为一个oauth认证服务。
 * 2.增加一系列的REST端点
 */
@EnableDiscoveryClient
@SpringBootApplication
public class DemoAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoAuthApplication.class, args);
    }

}
