package com.zx.cloudali;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName ConsumerMain8083
 * @Author Administrator
 * @Description TODO
 * @Date 2020/4/28 0028 16:02
 * @Version 1.0
 */

@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerMain8083 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerMain8083.class, args);
    }

}
