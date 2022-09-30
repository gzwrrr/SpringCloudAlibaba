package com.gontoy.springcloud.service.Impl;

import com.gontoy.springcloud.entities.Payment;
import com.gontoy.springcloud.mapper.PaymentMapper;
import com.gontoy.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author gzw
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.getPaymentById(id);
    }
}
