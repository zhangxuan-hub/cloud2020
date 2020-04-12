package com.zx.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MySelfRule
 * @Author Administrator
 * @Description TODO
 * @Date 2020/4/7 13:09
 * @Version 1.0
 */

@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule() {
        //定义负载均衡规则为随机
        return new RandomRule();
    }
}
