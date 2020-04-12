package com.zx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName Server7001
 * @Author Administrator
 * @Description TODO
 * @Date 2020/4/6 12:36
 * @Version 1.0
 */

@SpringBootApplication
//表示该服务是一个Eureka服务端
@EnableEurekaServer
public class Server7001 {

    public static void main(String[] args) {
        SpringApplication.run(Server7001.class, args);
    }
}
