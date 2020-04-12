package com.zx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName PaymentMain8001
 * @Author Administrator
 * @Description TODO
 * @Date 2020/4/5 19:58
 * @Version 1.0
 */

@SpringBootApplication
//表示该服务启用了discovery服务，可以通过该服务获取Eureka服务的详细列表
@EnableDiscoveryClient
public class PaymentMain8001 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class);
    }
}
