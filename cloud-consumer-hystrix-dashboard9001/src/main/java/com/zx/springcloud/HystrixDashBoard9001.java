package com.zx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @ClassName HystrixDashBoard9001
 * @Author Administrator
 * @Description TODO
 * @Date 2020/4/9 17:08
 * @Version 1.0
 */

@SpringBootApplication
//开启Hystix的图形化监控界面
@EnableHystrixDashboard
public class HystrixDashBoard9001 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashBoard9001.class, args);
    }
}
