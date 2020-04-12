package com.zx.springcloud.service.impl;

import com.zx.springcloud.service.IPaymentHystrixService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName PaymentHystrixService
 * @Author Administrator
 * @Description TODO
 * @Date 2020/4/9 14:53
 * @Version 1.0
 */

@Component
public class PaymentHystrixService implements IPaymentHystrixService {
    @Override
    public String payment_OK(Integer id) {
        return "--------PaymentHystrixService fallback-payment_OK, /(ㄒoㄒ)/~~ \t id: " + id;
    }

    @Override
    public String payment_TimeOut(Integer id) {
        return "--------PaymentHystrixService fallback-payment_TimeOut, /(ㄒoㄒ)/~~ \t id: " + id;
    }
}
