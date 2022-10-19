package com.gontoy.springcloud.controller;

import com.gontoy.springcloud.entities.CommonResult;
import com.gontoy.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author gzw
 */
@Slf4j
@RestController
@RequestMapping("/consumer/payment")
public class ConsumerController {

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/getPayment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")  Long id) {
        log.info("ConsumerController getPaymentById | id:{}", id);
        return restTemplate.getForObject(String.format("%s/payment/getPayment/%d", PAYMENT_URL, id), CommonResult.class);
    }

    @GetMapping(value = "/create")
    public CommonResult<Integer> create(Payment payment) {
        log.info("ConsumerController create | payment:{}", payment);
        return restTemplate.postForObject(String.format("%s/payment/create", PAYMENT_URL), payment, CommonResult.class);
    }

    /**
     * 测试 zipkin
     */
    @GetMapping(value = "/zipkin")
    public String zipkin() {
        String result = restTemplate.getForObject(String.format("%s/payment/zipkin", PAYMENT_URL), String.class);
        return "Hello zipkin";
    }
}
