package com.zx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName OrderHytrixMain80
 * @Author Administrator
 * @Description TODO
 * @Date 2020/4/9 8:37
 * @Version 1.0
 */

@SpringBootApplication
@EnableFeignClients
//开启Hystrix功能
@EnableHystrix
public class OrderHytrixMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderHytrixMain80.class, args);
    }
}
