package com.zjy.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZjyRule {
    @Bean
    public IRule myRule(){
        return new LocalRule();//自定义负载算法  默认是轮询
    }
}
