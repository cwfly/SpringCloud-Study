package com.cw.springcloud.controller;

import com.cw.springcloud.entities.CommonResult;
import com.cw.springcloud.entities.Payment;
import com.cw.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cwfly
 * @date 2020/6/26
 */
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入结果为： " + result);
        if (result>0){
            return new CommonResult(200, "插入数据成功", result);
        }else {
            return new CommonResult(500,"数据插入失败");
        }
    }

    @GetMapping("/payment/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果为： " + payment);
        if (payment!=null){
            return new CommonResult(200, "查询数据成功", payment);
        }else {
            return new CommonResult(400,"查询失败. id = " + id);
        }
    }
}
