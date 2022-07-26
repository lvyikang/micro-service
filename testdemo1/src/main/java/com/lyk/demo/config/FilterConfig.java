package com.lyk.demo.config;

import com.lyk.demo.filter.LogMDCFilter;
import com.lyk.demo.filter.LogMDCOncePerRequestFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 指定过滤器顺序
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<LogMDCOncePerRequestFilter> logMDCOncePerRequestFilterRegistration() {
        FilterRegistrationBean<LogMDCOncePerRequestFilter> registration = new FilterRegistrationBean<>();
        // 注入过滤器
        registration.setFilter(new LogMDCOncePerRequestFilter());
        // 拦截规则
        registration.addUrlPatterns("/*");
        // 过滤器名称
        registration.setName("logMDCOncePerRequestFilter");
        // 过滤器顺序
        registration.setOrder(1);
        return registration;
    }

    @Bean
    public FilterRegistrationBean<LogMDCFilter> logFilterRegistration() {
        FilterRegistrationBean<LogMDCFilter> registration = new FilterRegistrationBean<>();
        // 注入过滤器
        registration.setFilter(new LogMDCFilter());
        // 拦截规则
        registration.addUrlPatterns("/*");
        // 过滤器名称
        registration.setName("logFilter");
        // 过滤器顺序
        registration.setOrder(2);
        return registration;
    }


}
