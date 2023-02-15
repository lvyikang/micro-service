package com.lyk.demo.filter;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@WebFilter(filterName = "logFilter", urlPatterns = "/test/*")
public class LogMDCFilter implements Filter {

    private static final String UNIQUE_ID_NAME = "traceId";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
//        MDC.put(UNIQUE_ID_NAME, UUID.randomUUID().toString().replace("-", "").substring(0, 12));
//        try {
//            log.info("进过滤器====:{}", this.getClass().getName());
//            filterChain.doFilter(servletRequest, servletResponse);
//        } finally {
//            log.info("出过滤器====:{}", this.getClass().getName());
//            MDC.remove(UNIQUE_ID_NAME);
//        }
    }
}
