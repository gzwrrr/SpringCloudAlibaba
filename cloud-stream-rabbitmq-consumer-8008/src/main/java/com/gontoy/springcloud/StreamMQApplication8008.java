package com.gontoy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author gzw
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamMQApplication8008 {
    public static void main(String[] args) {
        SpringApplication.run(StreamMQApplication8008.class, args);
    }
}
