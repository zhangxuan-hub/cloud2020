package com.zx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName OpenFeignMain80
 * @Author Administrator
 * @Description TODO
 * @Date 2020/4/7 15:17
 * @Version 1.0
 */

@SpringBootApplication
//表示该服务启用feign功能
@EnableFeignClients
public class OpenFeignMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OpenFeignMain80.class, args);
    }
}
