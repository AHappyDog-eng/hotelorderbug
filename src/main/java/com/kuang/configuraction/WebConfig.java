package com.kuang.configuraction;

import com.kuang.Interceptors.WebInterceptors;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
   /* @Bean
    public WebInterceptors getJwtTokenInterceptor(){
        return new WebInterceptors();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getJwtTokenInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/Login")
                .excludePathPatterns("/Email/LoginVerify")
                .excludePathPatterns("/Email/Login")
                .excludePathPatterns("/oos/upload");
    }
*/
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .maxAge(3600)
                .allowCredentials(true);
    }
}
