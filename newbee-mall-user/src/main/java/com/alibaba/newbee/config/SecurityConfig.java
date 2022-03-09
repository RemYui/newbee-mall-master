package com.alibaba.newbee.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Author: Emilia
 * @Since: 2022.03.08 20:36
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     *  配置安全过滤
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                //放开以下请求
                antMatcher("**/index").antMatcher("**/login").antMatcher("**/register").anonymous()
                .and()
                //其他请求需要认证
                .antMatcher("/**")
                .authorizeRequests(auth -> auth.anyRequest().authenticated())
                .build();
    }

    /**
     * 从数据库获取数据认证
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }

    /**
     *过滤静态资源
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }
}
