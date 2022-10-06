package com.gontoy.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;

/**
 * @author gzw
 */
public class MyRibbonRule {
    @Bean
    public IRule myRule() {
        return new RandomRule();
    }
}
