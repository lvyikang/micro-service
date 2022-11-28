package com.lyk.demo.filter;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@WebFilter(filterName = "logMDCOncePerRequestFilter", urlPatterns = "/*")
public class LogMDCOncePerRequestFilter extends OncePerRequestFilter {
    //请求发向 servlet 时会被 Filter 拦截，如果 servlet 将请求转发给另一个 servlet，请求发向第二个 servlet 时，依旧会被相同的 Filter 拦截。结果就是一个请求被同一个 Filter 拦截了两次。
    //OncePerRequestFilter` 一个请求只被过滤器拦截一次。请求转发不会第二次触发过滤器。
    //OncePerRequestFilter是在一次外部请求中只过滤一次。对于服务器内部之间的forward等请求，不会再次执行过滤方法

    private static final String UNIQUE_ID_NAME = "traceId";

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        MDC.put(UNIQUE_ID_NAME, UUID.randomUUID().toString().replace("-", "").substring(0, 12));
        try {
            log.info("进过滤器====:{}", this.getClass().getName());
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        } finally {
            log.info("出过滤器====:{}", this.getClass().getName());
            MDC.remove(UNIQUE_ID_NAME);
        }
    }
}
