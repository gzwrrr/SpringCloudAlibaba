package com.gontoy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 主启动类
 * @author gzw
 */
@SpringBootApplication
@EnableFeignClients
public class ConsumerApplication7996 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication7996.class, args);
    }
}
