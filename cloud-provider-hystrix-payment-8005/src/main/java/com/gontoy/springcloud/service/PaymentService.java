package com.gontoy.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.concurrent.TimeUnit;

/**
 * @author gzw
 */
@Service
public class PaymentService {
    public String paymentInfo(Integer id) {
        return "Thread：" + Thread.currentThread().getName() + " paymentInfo | id:" + id;
    }

    /**
     * 下面的注解表示：
     * 超过 3 秒就服务降级，调用 paymentInfoTimeoutHandler 方法
     */
    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfoTimeout(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Thread：" + Thread.currentThread().getName() + " paymentInfoTimeout | id:" + id;
    }

    /**
     * 服务超时时，服务降级，返回这个函数兜底
     */
    public String paymentInfoTimeoutHandler(Integer id) {
        return "Thread：" + Thread.currentThread().getName() + " paymentInfoTimeoutHandler | id:" + id;
    }

    /**
     * 开启服务熔断
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            // 请求次数
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            // 失败率到达多少时跳闸
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    })
    public String paymentCircuitBreakerk(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("id 不能为负数");
        }
        // 这里使用到了 hutool
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + " 调用成功 | 流水号：" + serialNumber;
    }

    public String paymentCircuitBreakerFallback(@PathVariable("id") Integer id) {
        return "paymentCircuitBreakerFallback | id 不能为负数，请稍后再试";
    }
}
