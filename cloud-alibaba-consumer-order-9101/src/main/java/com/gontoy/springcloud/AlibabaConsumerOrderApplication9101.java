package com.gontoy.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * @author gzw
 */
@EnableDiscoveryClient
@SpringBootApplication
public class AlibabaProviderPaymentApplication9001 {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaProviderPaymentApplication9001.class, args);
        System.out.println("启动成功");
    }

}
