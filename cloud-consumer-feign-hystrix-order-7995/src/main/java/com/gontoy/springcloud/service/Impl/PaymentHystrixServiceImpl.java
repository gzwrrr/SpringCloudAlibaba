package com.gontoy.springcloud.service.Impl;

import com.gontoy.springcloud.service.PaymentHystrixService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author gzw
 */
@Component
public class PaymentHystrixServiceImpl implements PaymentHystrixService {

    @Override
    public String paymentInfo(@PathVariable("id") Integer id) {
        return "paymentInfo | 使用实现类的方式实现服务降级 | id:" + id;
    }

    @Override
    public String paymentInfoTimeout(@PathVariable("id") Integer id) {
        return "paymentInfoTimeout | 使用实现类的方式实现服务降级 | id:" + id;
    }
}
