package com.zx.springcloud.servce;

/**
 * @ClassName IPaymentService
 * @Author Administrator
 * @Description TODO
 * @Date 2020/4/8 21:21
 * @Version 1.0
 */
public interface IPaymentService {

    String paymentInfo_OK(Integer id);

    String paymentInfo_TimeOut(Integer id) throws InterruptedException;

    public String paymentCircuitBreaker(Integer id);
}
