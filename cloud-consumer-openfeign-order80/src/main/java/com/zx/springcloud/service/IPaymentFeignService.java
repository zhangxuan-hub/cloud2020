package com.zx.springcloud.service;

import com.zx.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName IPaymentFeignService
 * @Author Administrator
 * @Description TODO
 * @Date 2020/4/8 8:19
 * @Version 1.0
 */

@Component
/**
 * @Description 表示该接口是一个feign调用，value的值是需要调用的服务的服务名
 */
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface IPaymentFeignService {

    @PostMapping(value = "/pay/get")
    public CommonResult getPaymentById(@RequestParam("id") Long id);

    @PostMapping(value = "/pay/test")
    public String paymentFeignTimeOut(@RequestParam("param") String param);
}
