package com.gontoy.springcloud.controller;

import com.gontoy.springcloud.entities.CommonResult;
import com.gontoy.springcloud.entities.Payment;
import com.gontoy.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author gzw
 */
@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/getPayment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")  Long id) {
        log.info("PaymentController getPaymentById | id:{}", id);
        Payment payment = paymentService.getPaymentById(id);

        if (payment != null) {
            return new CommonResult(200, "查询成功", payment);
        } else {
            return new CommonResult(444, "没有记录", null);
        }
    }

    @PostMapping(value = "/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("PaymentController create | payment:{} | result:{}", payment, result);
        if (result > 0) {
            return new CommonResult(200, "插入数据成功", result);
        } else {
            return new CommonResult(444, "插入数据失败", null);
        }
    }
}
