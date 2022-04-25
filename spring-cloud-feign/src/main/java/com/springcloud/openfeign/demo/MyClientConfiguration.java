package com.springcloud.openfeign.demo;

import feign.RequestInterceptor;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyClientConfiguration {

    // @Bean
    // public OkHttpClient client() {
    //     return new OkHttpClient();
    // }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("user", "username");
            requestTemplate.header("password", "password");
            requestTemplate.header("Accept", "application/json");
        };
    }

    // All the requests will contain the basic authentication header.
    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("username", "password");
    }
}
