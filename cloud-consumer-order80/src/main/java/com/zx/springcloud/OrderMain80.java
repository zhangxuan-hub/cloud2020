package com.zx.springcloud;

import com.zx.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @ClassName OrderMain80
 * @Author Administrator
 * @Description TODO
 * @Date 2020/4/6 9:12
 * @Version 1.0
 */

@SpringBootApplication
//该服务会调用服务名为"CLOUD-PAYMENT-SERVICE"的集群服务，其使用的负载均衡规则为定义在MySelfRule类中的规则
//如果使用Ribbon默认的负载均衡规则，则不需要加该注解
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MySelfRule.class)
public class OrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class);
    }
}
