package com.springcloud.openfeign;

import com.springcloud.openfeign.authorization.AuthorizationFeignClient;
import com.springcloud.openfeign.authorization.DefaultAuthorizationClient;
import com.springcloud.openfeign.authorization.DefaultAuthorizationFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClientBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

// TODO. Enable component scanning for interfaces that declare they are Feign clients
//  通过添加注解来自动"注入"所有标记了@FeignClient("authz")注解class(interface)
// 查看该类型的源码 FeignClientFactoryBean feignClientFactoryBean
// https://docs.spring.io/spring-cloud-openfeign/docs/current/reference/html/

// 分布式系统中，网关层或应用层调用"后端的微服务"，通常使用SpringCloud Feign去调用，简单方便
// 开发环境和测试环境共用一套nacos
// https://icode.best/i/03263743301620 feign根据环境动态指定服务名

@SpringBootApplication
@EnableFeignClients
public class SpringCloudFeignClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudFeignClientApplication.class, args);
    }

    // 创建指定类型的Feign Client, 通过调用方法来发送请求
    private static void test(ApplicationContext applicationContext) {
        FeignClientBuilder clientBuilder = new FeignClientBuilder(applicationContext);
        DefaultAuthorizationClient feignClient = clientBuilder
                .forType(DefaultAuthorizationClient.class, "testClient")
                .url("base url for the request")
                // .fallback()
                .build();
        feignClient.checkPermission("", "", "");
    }

    @Bean
    @Autowired
    DefaultAuthorizationClient createDefaultAuthorizationClient(AuthorizationFeignClient feignClient) {
        return new DefaultAuthorizationFeignClient(feignClient);
    }
}
