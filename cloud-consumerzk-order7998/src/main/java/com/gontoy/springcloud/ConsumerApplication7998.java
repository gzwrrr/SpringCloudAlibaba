package com.gontoy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 主启动类
 * @author gzw
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerApplication7998 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication7998.class, args);
    }
}
