package com.zx.springcloud.servce.impl;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zx.springcloud.servce.IPaymentService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName PaymentServiceImpl
 * @Author Administrator
 * @Description TODO
 * @Date 2020/4/8 21:22
 * @Version 1.0
 */

@Service
public class PaymentServiceImpl implements IPaymentService {

    private static final Integer TIME = 3000;

    @Override
    public String paymentInfo_OK(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "\t paymentInfo_OK id: " + id + "\t O(∩_∩)O哈哈";
    }

    @Override
    /**
     * @Description 添加@HystrixCommand注解并设置fallbackMethod属性后，方法就具备了降级功能；
     *              1.fallbackMethod: 该属性的值就是当需要降级时，调用的方法, 该方法会给用户返回相对友好的提示;
     *              2.commandProperties: 该属性的值是一个数组；
     *               (1)@HystrixProperty(name = "execute.isolation.thread.timeoutMilliseconds", value = "3000")
     *                   name: 超时时间单位ms，value：超时时间
     *                   说明: 3秒之内服务提供方法给出相应，则调用正常的服务方法，超过3秒则调用降级方法，即:fallbackMethod属性指定的方法
     **/
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfo_TimeOut(Integer id) throws InterruptedException {

//        int res = 10 / 0;
        TimeUnit.MILLISECONDS.sleep(TIME);

        return "线程池：" + Thread.currentThread().getName() + "\t paymentInfo_TimeOut id: " + id + "\t 耗时" + TIME + "秒钟";
    }

    /**
     * @Description 降级时调用的方法
     */
    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "\t 8001系统繁忙或出错，请稍后再试！ id: " + id + "/(ㄒoㄒ)/~~";
    }

    //=====服务熔断
    /**
     * @Description 以下配置的含义是：1.开启断路器
     *                             2.在10内，如果10次请求的有60%都失败了，则进行断路进，即：该服务无法被请求，启用降级服务
     *                             3.等待一段时间后，再回复请求
     */
    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallbak", commandProperties = {
            //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            //请求次数
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            //时间窗口期
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            //失败率达到多少后跳闸
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    })
    public String paymentCircuitBreaker(Integer id) {
        if(id<0) {
            throw new RuntimeException("***********id不能是负数");
        }
        String serialNumber  = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t 调用成功，流水号: "+serialNumber;
    }

    public String paymentCircuitBreaker_fallbak(Integer id) {
        return "id不能是负数, 请稍后再试，/(ㄒoㄒ)/~~ id: " + id;
    }
}
