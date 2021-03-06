package com.zx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName ConfigCenterMain3344
 * @Author Administrator
 * @Description TODO
 * @Date 2020/4/12 11:55
 * @Version 1.0
 */

@SpringBootApplication
//激活配置中心
@EnableConfigServer
public class ConfigCenterMain3344 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMain3344.class, args);
    }
}
