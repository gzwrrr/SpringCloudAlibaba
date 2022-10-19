package com.gontoy.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * @author gzw
 */
@EnableDiscoveryClient
@SpringBootApplication
public class AlibabaProviderPayment9001Application {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaProviderPayment9001Application.class, args);
        System.out.println("启动成功");
    }

}
