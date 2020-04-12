package com.zx.springcloud.service.impl;

import com.zx.springcloud.dao.PaymentDao;
import com.zx.springcloud.entities.Payment;
import com.zx.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName PaymentServiceImp
 * @Author Administrator
 * @Description TODO
 * @Date 2020/4/5 21:23
 * @Version 1.0
 */

@Service
public class PaymentServiceImp implements PaymentService {

    /**
     * 当持久层使用@Mapper注解标记后，注入时需要使用@Resource
     */
    @Resource
    PaymentDao paymentDao;

    @Override
    public int crate(Payment payment) {

        return paymentDao.crate(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {

        return paymentDao.getPaymentById(id);
    }
}
