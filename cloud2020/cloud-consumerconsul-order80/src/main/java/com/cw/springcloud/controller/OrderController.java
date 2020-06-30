package com.cw.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cw.springcloud.entities.CommonResult;
import com.cw.springcloud.entities.Payment;

import lombok.extern.slf4j.Slf4j;

/**
 * @author cwfly
 * @date 2020/6/26
 */
@RestController
@Slf4j
public class OrderController {
    // private static final String PAYMENT_URL = "http://localhost:8001";
    private static final String PAYMENT_URL = "http://cloud-payment-service";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String getPaymentById(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/consul", String.class);
    }
}
