package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 主启动类
 * @author gzw
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerApplication7997 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication7997.class, args);
    }
}
