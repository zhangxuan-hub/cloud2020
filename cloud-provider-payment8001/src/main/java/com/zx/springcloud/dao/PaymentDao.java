package com.zx.springcloud.dao;

import com.zx.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName PaymentDao
 * @Author Administrator
 * @Description TODO
 * @Date 2020/4/5 20:59
 * @Version 1.0
 */

@Mapper
public interface PaymentDao {

    public int crate(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
