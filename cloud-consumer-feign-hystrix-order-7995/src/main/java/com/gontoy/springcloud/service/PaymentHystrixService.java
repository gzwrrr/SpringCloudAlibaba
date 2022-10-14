package com.gontoy.springcloud.service;

import com.gontoy.springcloud.service.Impl.PaymentHystrixServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author gzw
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE", fallback = PaymentHystrixServiceImpl.class)
public interface PaymentHystrixService {
    @GetMapping(value = "/payment/hystrix/success/{id}")
    public String paymentInfo(@PathVariable("id") Integer id);

    @GetMapping(value = "/payment/hystrix/fail/{id}")
    public String paymentInfoTimeout(@PathVariable("id") Integer id);
}
