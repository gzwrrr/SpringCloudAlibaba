package com.gontoy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 主启动类
 * @author gzw
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class ConsumerApplication7995 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication7995.class, args);
    }
}
