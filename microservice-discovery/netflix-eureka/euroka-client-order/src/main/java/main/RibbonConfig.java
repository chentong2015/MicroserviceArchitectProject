package main;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RibbonConfig {

    // TODO. 通过服务发现调用到指定服务名称的service，实现微服务之间的负载均衡
    @Bean
    @LoadBalanced // ribbon负载均衡注解
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
