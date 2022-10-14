package com.gontoy.springcloud.controller;

import com.gontoy.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
@RequestMapping("/consumer/payment")
@DefaultProperties(defaultFallback = "paymentInfoGlobalHandler")
public class PaymentHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/hystrix/success/{id}")
    public String paymentInfo(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfo(id);
        log.info("PaymentHystrixController paymentInfo | result:{}", result);
        return result;
    }

    /**
     * 下面的注解表示：
     * 超过 1.5 秒就服务降级，调用 paymentInfoTimeoutHandler 方法
     */
    @GetMapping("/hystrix/fail/{id}")
    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
    public String paymentInfoTimeout(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfoTimeout(id);
        log.info("PaymentHystrixController paymentInfoTimeout | result:{}", result);
        return result;
    }

    /**
     * 服务超时时，服务降级，返回这个函数兜底
     */
    public String paymentInfoTimeoutHandler(Integer id) {
        return "Thread：" + Thread.currentThread().getName() + " consumer paymentInfoTimeoutHandler | id:" + id;
    }

    /**
     * 下面的注解表示：
     * 服务不可用时使用全局的服务降级方法
     */
    @GetMapping("/hystrix/fail2/{id}")
    @HystrixCommand
    public String paymentInfoTimeoutTwo(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfoTimeout(id);
        log.info("PaymentHystrixController paymentInfoTimeout | result:{}", result);
        return result;
    }

    /**
     * 全局的服务降级对应的方法
     */
    public String paymentInfoGlobalHandler() {
        return "Global 全局异常处理，请稍后再试";
    }
}
