package com.zx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName Server7002
 * @Author Administrator
 * @Description TODO
 * @Date 2020/4/6 13:29
 * @Version 1.0
 */

@SpringBootApplication
@EnableEurekaServer
public class Server7002 {

    public static void main(String[] args) {
        SpringApplication.run(Server7002.class, args);
    }
}
