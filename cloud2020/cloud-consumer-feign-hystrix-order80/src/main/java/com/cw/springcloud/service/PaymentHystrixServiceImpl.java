package com.cw.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author cwfly
 * @date 2020/7/12
 */
@Component
public class PaymentHystrixServiceImpl implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentHystrixServiceImpl-paymentInfo_OK o(╯□╰)o";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "PaymentHystrixServiceImpl-paymentInfo_TimeOut o(╯□╰)o";
    }
}
