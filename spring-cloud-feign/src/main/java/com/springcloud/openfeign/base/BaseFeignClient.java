package com.springcloud.openfeign.base;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("name")
public interface BaseFeignClient {

    @RequestMapping("/")
    String getName();
}
