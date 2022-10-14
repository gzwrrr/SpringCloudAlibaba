package com.gontoy.springcloud.controller;

import com.gontoy.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/hystrix/success/{id}")
    public String paymentInfo(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo(id);
        log.info("paymentInfo | id:{} | serverPort:{} | result:{}", id, serverPort, result);
        return result;
    }

    @GetMapping("/hystrix/fail/{id}")
    public String paymentInfoTimeout(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfoTimeout(id);
        log.info("paymentInfo | id:{} | serverPort:{} | result:{}", id, serverPort, result);
        return result;
    }

    @GetMapping("/hystrix/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        String result = paymentService.paymentCircuitBreakerk(id);
        log.info("paymentCircuitBreaker | id:{} | serverPort:{} | result:{}", id, serverPort, result);
        return result;
    }
}
