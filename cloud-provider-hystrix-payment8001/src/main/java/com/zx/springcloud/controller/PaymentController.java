package com.zx.springcloud.controller;

import com.zx.springcloud.servce.IPaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @ClassName PaymentController
 * @Author Administrator
 * @Description TODO
 * @Date 2020/4/8 21:28
 * @Version 1.0
 */

@RestController
@RequestMapping(value = "hystrix")
public class PaymentController {

    @Autowired
    private IPaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;


    Logger logger = LoggerFactory.getLogger(PaymentController.class);

    @PostMapping(value = "/payment/ok")
    public String payment_OK(Integer id) {
        String result = paymentService.paymentInfo_OK(id);
        logger.info("**** result: {} ****", result);

        return result;
    }

    @PostMapping(value = "/payment/timeout")
    public String payment_TimeOut(Integer id) throws InterruptedException {
        String result = paymentService.paymentInfo_TimeOut(id);
        logger.info("**** result: {} ****", result);

        return result;
    }

    //=====服务熔断
    @PostMapping(value = "/payment/circuit")
    public String paymentCircuitBreaker(Integer id) {
        String result = paymentService.paymentCircuitBreaker(id);
        logger.info("*****result: {}", result);

        return result;
    }
}
