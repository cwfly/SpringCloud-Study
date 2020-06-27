package com.cw.springcloud.service;

import com.cw.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author cwfly
 * @date 2020/6/26
 */
public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
