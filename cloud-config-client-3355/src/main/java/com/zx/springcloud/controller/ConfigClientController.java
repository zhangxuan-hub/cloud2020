package com.zx.springcloud.controller;

import com.zx.springcloud.ConfigClientMain3355;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ConfigClientController
 * @Author Administrator
 * @Description TODO
 * @Date 2020/4/12 13:47
 * @Version 1.0
 */

@RestController
@RefreshScope
@RequestMapping(value = "configclient")
public class ConfigClientController {

    Logger logger = LoggerFactory.getLogger(ConfigClientMain3355.class);

    @Value("${config.info}")
    private String configInfo;

    @GetMapping(value = "/configinfo")
    public String getConfigInfo() {
        logger.info("configInfo: {}", configInfo);
        return configInfo;
    }
}
