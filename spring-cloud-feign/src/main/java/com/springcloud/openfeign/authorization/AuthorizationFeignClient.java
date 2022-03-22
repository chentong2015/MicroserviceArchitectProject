package com.springcloud.openfeign.authorization;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FunctionalInterface
@FeignClient("authz")
public interface AuthorizationFeignClient {

    @PostMapping(path = "/permissions/check",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    boolean checkPermission(@RequestHeader("Authorization") String authorizationHeader, @RequestBody String permissionRequest);

}
