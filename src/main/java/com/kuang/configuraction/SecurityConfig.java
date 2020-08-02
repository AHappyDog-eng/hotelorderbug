package com.kuang.configuraction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // 加密密码
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }



    /*权限*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 关闭csrf验证(防止跨站请求伪造攻击)
        http.csrf().disable();
        System.out.println("启动安全 securityConfig");
        /*
        // 未登录时：返回状态码401
        http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);
        // 无权访问时：返回状态码403
        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler);
        */
        /*配置权限*/
        /*http.authorizeRequests()
                *//*默认首页可以全部的人访问*//*

                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll();*/
        /*用户权限为admin的用户可以访问/getUser*/
        /*.antMatchers("/getUser").hasRole("admin");*/
        /*没有权限就到登录页面*/
        /*http.formLogin();*/
        /*重定向到自己页面*/
        /*http.formLogin()
                .loginPage("/login")
                .failureUrl("/login/error");*/
                /*.failureUrl("/login/error")
                .defaultSuccessUrl("/");*/

        /****************************************************************************/
    }
    /*认证*/
/*
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        *//*基本格式认证*//*
        *//*auth.inMemoryAuthentication();*//*

    }*/


}
