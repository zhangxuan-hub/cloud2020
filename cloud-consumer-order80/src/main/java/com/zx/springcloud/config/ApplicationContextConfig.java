package com.zx.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName ApplicationContextConfig
 * @Author Administrator
 * @Description TODO
 * @Date 2020/4/6 9:21
 * @Version 1.0
 */

@Configuration
public class ApplicationContextConfig {

    @Bean
    //该注解让RestTemplate具有负载均衡的能力
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
