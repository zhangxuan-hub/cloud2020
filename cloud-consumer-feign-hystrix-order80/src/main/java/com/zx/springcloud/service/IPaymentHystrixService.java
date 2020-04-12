package com.zx.springcloud.service;

import com.zx.springcloud.service.impl.PaymentHystrixService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName IPaymentHystrixService
 * @Author Administrator
 * @Description TODO
 * @Date 2020/4/9 8:40
 * @Version 1.0
 */

@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT", fallback = PaymentHystrixService.class)
public interface IPaymentHystrixService {

    @PostMapping(value = "/hystrix/payment/ok")
    public String payment_OK(@RequestParam("id") Integer id);

    @PostMapping(value = "/hystrix/payment/timeout")
    public String payment_TimeOut(@RequestParam("id") Integer id);
}
