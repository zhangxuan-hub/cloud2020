package com.zx.springcloud.service;


import com.zx.springcloud.entities.Payment;

/**
 * @ClassName PaymentService
 * @Author Administrator
 * @Description TODO
 * @Date 2020/4/5 21:21
 * @Version 1.0
 */
public interface PaymentService {

    public int crate(Payment payment);

    public Payment getPaymentById(Long id);
}
