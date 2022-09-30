package com.gontoy.springcloud.controller;

import com.gontoy.springcloud.entities.CommonResult;
import com.gontoy.springcloud.entities.Payment;
import com.gontoy.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author gzw
 */
@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/getPayment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")  Long id) {
        log.info("PaymentController getPaymentById | port:{} | id:{}", serverPort, id);
        Payment payment = paymentService.getPaymentById(id);

        if (payment != null) {
            return new CommonResult(200, String.format("查询成功 | port:%s", serverPort), payment);
        } else {
            return new CommonResult(444, "没有记录", null);
        }
    }

    @PostMapping(value = "/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("PaymentController create | port:{} | payment:{} | result:{}", serverPort, payment, result);
        if (result > 0) {
            return new CommonResult(200, String.format("插入数据成功 | port:%s", serverPort), result);
        } else {
            return new CommonResult(444, "插入数据失败", null);
        }
    }

    @GetMapping(value = "/discovery")
    public Object discovery() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("ServerId:{} | Host:{} | Port:{} | Uri:{}", instance.getInstanceId(), instance.getHost(), instance.getPort(), instance.getUri());
        }
        return discoveryClient;
    }
}
