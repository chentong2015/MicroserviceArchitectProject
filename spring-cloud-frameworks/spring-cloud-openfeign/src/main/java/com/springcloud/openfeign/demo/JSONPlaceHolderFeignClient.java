package com.springcloud.openfeign.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// TODO. FeignClient客户端提供配置信息 ==> 和使用FeignClientBuilder构建的一致
// 1. each Feign client is composed of a set of customizable components.
// 2. For each Feign client, a logger is created by default.
// 3. (configuration = MyClientConfiguration.class) 可以自定义配置

@FeignClient(value = "testClient", url = "https://localhost:8080/")
public interface JSONPlaceHolderFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/data")
    String getResponseData();

    @RequestMapping(method = RequestMethod.DELETE, value = "/data/{id}",
            produces = "application/json")
    String deleteById(@PathVariable("id") Long id);
}
