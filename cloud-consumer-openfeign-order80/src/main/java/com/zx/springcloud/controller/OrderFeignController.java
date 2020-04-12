package com.zx.springcloud.controller;

import com.zx.springcloud.entities.CommonResult;
import com.zx.springcloud.service.IPaymentFeignService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName OrderFeignController
 * @Author Administrator
 * @Description TODO
 * @Date 2020/4/8 8:44
 * @Version 1.0
 */

@RestController
@RequestMapping(value = "consumer")
public class OrderFeignController {
    @Resource
    private IPaymentFeignService feignService;

    @PostMapping(value = "/payment/get")
    public CommonResult getPaymentById(Long id) {
        //客户端掉用该方法，该方法调用feign接口
        return feignService.getPaymentById(id);
    }

    @PostMapping(value = "/payment/test")
    public String paymentFeignTimeout(String param) {
        return feignService.paymentFeignTimeOut(param);
    }
}
