package com.zx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName Payment8002
 * @Author Administrator
 * @Description TODO
 * @Date 2020/4/6 16:00
 * @Version 1.0
 */

@SpringBootApplication
@EnableEurekaClient
public class PaymentMain8003 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8003.class, args);
    }
}
