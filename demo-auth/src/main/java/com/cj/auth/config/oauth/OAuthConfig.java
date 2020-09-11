package com.cj.auth.config.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.sql.DataSource;

/**
 * 描述：oAuth的认证服务
 *
 * @author caojing
 * @create 2020-09-10-12:08
 */
@EnableAuthorizationServer
@Configuration
public class OAuthConfig extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private DataSource dataSource;
    /**
     * 密码模式需要注入认证管理器
     */
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;
    @Autowired
    public PasswordEncoder passwordEncoder;
    /**
     * 用户服务
     */
    @Autowired
    public UserDetailsService userDetailsService;

    @Bean
    ClientDetailsService clientDetailsService() {
        return new JdbcClientDetailsService(dataSource);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(clientDetailsService());
//        clients.inMemory()
//                .withClient("test")
//                .secret(new BCryptPasswordEncoder().encode("test"))
////                .authorizedGrantTypes("refresh_token", "password", "client_credentials")
//                //                     authorization_code
//                .authorizedGrantTypes("password", "refresh_token")
//                .scopes("all");

    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

        endpoints.authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService)
                .tokenStore(new RedisTokenStore(redisConnectionFactory))
                .setClientDetailsService(clientDetailsService());
//                .userDetailsService(userDetailsService);
    }

//    @Bean
//    AuthorizationServerTokenServices tokenServices() {
//        DefaultTokenServices services = new DefaultTokenServices();
//        services.setClientDetailsService(clientDetailsService());
//        services.setSupportRefreshToken(true);
//        services.setTokenStore(new RedisTokenStore(redisConnectionFactory));
//        return services;
//    }
public static void main(String[] args) {
    String password = "test";
    String pwd = new BCryptPasswordEncoder().encode(password);
    System.out.println(pwd);
}
}
