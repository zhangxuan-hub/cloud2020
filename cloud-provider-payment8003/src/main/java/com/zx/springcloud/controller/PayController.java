package com.zx.springcloud.controller;

import com.zx.springcloud.entities.CommonResult;
import com.zx.springcloud.entities.Payment;
import com.zx.springcloud.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName PayController
 * @Author Administrator
 * @Description TODO
 * @Date 2020/4/5 21:28
 * @Version 1.0
 */

@RestController
@RequestMapping(value = "pay")
public class PayController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    Logger logger = LoggerFactory.getLogger(PayController.class);

    @PostMapping(value = "/create")
    public CommonResult create(Payment payment) {
        int result = paymentService.crate(payment);
        if (result > 0) {
            return new CommonResult(200, "插入数据成功, serverPort: " + serverPort, result);
        } else {
            return new CommonResult(444, "插入数据失败", null);
        }
    }

    @PostMapping(value = "/get")
    public CommonResult getPaymentById(Long id) {
        Payment result = paymentService.getPaymentById(id);
        if (result != null) {
            return new CommonResult(200, "查找数据成功, serverPort: " + serverPort, result);
        } else {
            return new CommonResult(444, "查找数据失败，id: " + id, null);
        }
    }
}
