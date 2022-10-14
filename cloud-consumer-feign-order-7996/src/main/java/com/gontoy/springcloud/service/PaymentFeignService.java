package com.gontoy.springcloud.service;

import com.gontoy.springcloud.entities.CommonResult;
import com.gontoy.springcloud.entities.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author gzw
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping(value = "/payment/hystrix/success/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")  Long id);

    @GetMapping(value = "/payment/hystrix/fail/{id}")
    public String paymentInfoTimeout(@PathVariable("id") Integer id);

}
