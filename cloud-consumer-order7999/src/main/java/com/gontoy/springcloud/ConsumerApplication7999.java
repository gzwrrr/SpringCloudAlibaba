package com.gontoy.springcloud;

import com.gontoy.myrule.MyRibbonRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * 主启动类
 * @author gzw
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MyRibbonRule.class)
public class ConsumerApplication7999 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication7999.class, args);
    }
}
