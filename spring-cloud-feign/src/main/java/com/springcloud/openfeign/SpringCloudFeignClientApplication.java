package com.springcloud.openfeign;

import com.springcloud.openfeign.authorization.AuthorizationFeignClient;
import com.springcloud.openfeign.authorization.DefaultAuthorizationClient;
import com.springcloud.openfeign.authorization.DefaultAuthorizationFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

// Provides OpenFeign integrations for Spring Boot apps through autoconfiguration
// https://docs.spring.io/spring-cloud-openfeign/docs/4.0.0-M1/reference/html/
// https://docs.spring.io/spring-cloud-openfeign/docs/current/reference/html/

// 查看该类型的源码 FeignClientFactoryBean feignClientFactoryBean;
@SpringBootApplication
@EnableFeignClients
public class SpringCloudFeignClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudFeignClientApplication.class, args);
    }

    @Bean
    @Autowired
    DefaultAuthorizationClient createDefaultAuthorizationClient(AuthorizationFeignClient feignClient) {
        return new DefaultAuthorizationFeignClient(feignClient);
    }
}
