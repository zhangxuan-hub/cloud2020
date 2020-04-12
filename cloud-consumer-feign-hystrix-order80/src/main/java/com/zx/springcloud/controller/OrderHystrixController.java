package com.zx.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.zx.springcloud.service.IPaymentHystrixService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName PaymentHystrixController
 * @Author Administrator
 * @Description TODO
 * @Date 2020/4/9 8:46
 * @Version 1.0
 */

@RestController
@RequestMapping(value = "consumer")
/**
 * @Description 在controller层的类上添加@DefaultProperties注解，并配置属性，就开启了全局降级配置，在需要执行统一降级方法的方法上添加@HystrixCommand注解。
 *              当没有配置降级的方法出现异常或在指定时间内没有收到服务端的回复后，就会调用全局降级所指定的方法。如: payment_OK()方法就会调用payment_Global_FallbackMethod()方法
 *              如果在全局降级类中，有方法专门配置了降级，则当该方法异常或在指定时间内没有收到服务端的回复后，调用自己配置的降级方法。如：payment_TimeOut()方法就会调用paymentInfo_TimeOutHandler()方法。
 */

//@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod(Integer id)")
public class OrderHystrixController {

    @Resource
    private IPaymentHystrixService paymentHystrixService;

    @PostMapping(value = "/payment/hystrix/ok")
//    @HystrixCommand
    public String payment_OK(Integer id) {
//        int res = 10 / 0;
        return paymentHystrixService.payment_OK(id);
    }

    @PostMapping(value = "/payment/hystrix/timeout")
    /**
     * @Description 添加@HystrixCommand注解并设置fallbackMethod属性后，方法就具备了降级功能；
     *              1.fallbackMethod: 该属性的值就是当需要降级时，调用的方法, 该方法会给用户返回相对友好的提示;
     *              2.commandProperties: 该属性的值是一个数组；
     *               (1)@HystrixProperty(name = "execute.isolation.thread.timeoutMilliseconds", value = "3000")
     *                   name: 超时时间单位ms，value：超时时间
     *                   说明: 1.5秒之内未收到服务端的返回结果，则调用降级方法，即:fallbackMethod属性指定的方法
     **/
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
    public String payment_TimeOut(Integer id) {
        int res = 10 / 0;

        return paymentHystrixService.payment_TimeOut(id);
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "我是80端口 \t 对方系统繁忙或出错，请稍后再试！ id: " + id + "/(ㄒoㄒ)/~~";
    }

    //全局fallback
    public String payment_Global_FallbackMethod(Integer id) {
        return "全局异常处理信息，请稍后再试！/(ㄒoㄒ)/~~";
    }
}
