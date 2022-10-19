package com.gontoy.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * @author gzw
 */
@EnableDiscoveryClient
@SpringBootApplication
public class AlibabaProviderPaymentApplication9002 {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaProviderPaymentApplication9002.class, args);
    }

}
