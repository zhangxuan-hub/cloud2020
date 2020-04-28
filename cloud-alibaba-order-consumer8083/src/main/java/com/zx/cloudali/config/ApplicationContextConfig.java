package com.zx.cloudali.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName ApplicationContextConfig
 * @Author Administrator
 * @Description TODO
 * @Date 2020/4/28 0028 16:03
 * @Version 1.0
 */

@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced
    public RestTemplate getTemplate() {
        return new RestTemplate();
    }
}
