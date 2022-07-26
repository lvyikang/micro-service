package com.lyk.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.net.Inet4Address;
import java.net.UnknownHostException;

@Slf4j
@Component
public class SwaggerPrintConfig implements ApplicationListener<WebServerInitializedEvent> {

    @Override
    public void onApplicationEvent(WebServerInitializedEvent webServerInitializedEvent) {
        try {
            // 获取IP
            String hostAddress = Inet4Address.getLocalHost().getHostAddress();
            // 获取端口号
            int port = webServerInitializedEvent.getWebServer().getPort();
            // 获取应用名
            String applicationName = webServerInitializedEvent.getApplicationContext().getApplicationName();
            // 打印 swagger 文档地址
            log.info("项目启动启动成功！swagger 接口文档地址: http://" + hostAddress + ":" + port + applicationName + "/swagger-ui.html");
            // 打印 swagger2 文档地址
            log.info("项目启动启动成功！swagger2 接口文档地址: http://" + hostAddress + ":" + port + applicationName + "/doc.html");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
