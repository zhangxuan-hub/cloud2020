package com.zx.cloudali.controller;

import com.zx.cloudali.config.ApplicationContextConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PaymentController
 * @Author Administrator
 * @Description TODO
 * @Date 2020/4/28 0028 16:05
 * @Version 1.0
 */

@RestController
@RequestMapping("nacos")
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private Integer serverPort;
    @Value("${service-url.nacos-user-service}")
    private String serviceName;

    @Autowired
    private ApplicationContextConfig contextConfig;

    @PostMapping("/payment")
    public String getPayment(Long id) {
        RestTemplate template = contextConfig.getTemplate();
        MultiValueMap<String, Long> param = new LinkedMultiValueMap<>();
        List<Long> list = new ArrayList<>();
        list.add(id);
        param.put("id", list);
        System.out.println("serviceName: " + serviceName);
        return template.postForObject("http://" + serviceName + "/pay/create", param, String.class);
    }
}
