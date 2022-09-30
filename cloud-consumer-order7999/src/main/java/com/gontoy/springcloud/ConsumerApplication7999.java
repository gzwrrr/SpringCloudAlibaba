package com.gontoy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 主启动类
 * @author gzw
 */
@SpringBootApplication
@EnableEurekaClient
public class ConsumerApplication7999 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication7999.class, args);
    }
}
