package com.zx.springcloud.controller;

import com.zx.springcloud.entities.CommonResult;
import com.zx.springcloud.entities.Payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName OrderController
 * @Author Administrator
 * @Description TODO
 * @Date 2020/4/6 9:16
 * @Version 1.0
 */

@RestController
@RequestMapping(value = "consumer")
public class OrderController {

//    public static final String PAYMENT_URL = "http://localhost:8001";
    //当服务提供者为集群时，consumer的服务提供者链接需要写成http://服务名的形式
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Autowired
    private RestTemplate restTemplate;

    Logger logger = LoggerFactory.getLogger(OrderController.class);

    @PostMapping(value = "/pay/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/pay/create", payment, CommonResult.class);
    }

    @PostMapping(value = "/pay/get")
    public CommonResult<Payment> getPayment(Long id) {
        MultiValueMap<String, Long> param = new LinkedMultiValueMap();
        List<Long> list = new ArrayList<>();
        list.add(id);
        param.put("id", list);
        return restTemplate.postForObject(PAYMENT_URL + "/pay/get", param, CommonResult.class);
    }

    @PostMapping(value = "/pay/getForEntity")
    public CommonResult getPaymentByEntity(Long id) {
        MultiValueMap<String, Long> params = new LinkedMultiValueMap<>();
        List<Long> list = new ArrayList<>();
        list.add(id);
        params.put("id", list);
        ResponseEntity<CommonResult> entity = restTemplate.postForEntity(PAYMENT_URL + "/pay/get", params, CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        }else {
            return new CommonResult(444, "获取数据失败", null);
        }

    }
}
