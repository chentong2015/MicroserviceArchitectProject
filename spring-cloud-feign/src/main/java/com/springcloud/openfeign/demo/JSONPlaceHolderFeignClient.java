package com.springcloud.openfeign.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 通过自定义的配置，提供组件的配置
// each Feign client is composed of a set of customizable components.
@FeignClient(value = "jplaceholder",
        url = "https://localhost:8080/",
        configuration = MyClientConfiguration.class)
public interface JSONPlaceHolderFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/data")
    String getResponseData();

    @RequestMapping(method = RequestMethod.DELETE, value = "/data/{id}", produces = "application/json")
    String deleteById(@PathVariable("id") Long id);
}
