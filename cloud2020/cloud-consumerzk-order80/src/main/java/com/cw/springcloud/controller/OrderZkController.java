package com.cw.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author cwfly
 * @date 2020/6/27
 */
@RestController
@Slf4j
public class OrderZkController {
    private static final String PAYMENT_URL = "http://cloud-payment-service";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String getPaymentById(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/zk", String.class);
    }
}
