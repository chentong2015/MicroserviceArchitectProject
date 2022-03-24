package com.springcloud.openfeign.client.callback;

import org.springframework.cloud.client.circuitbreaker.NoFallbackAvailableException;

public class MyCallback implements BaseCallbackFeignClientInterface {

    @Override
    public String getHello() {
        throw new NoFallbackAvailableException("Boom!", new RuntimeException());
    }

    @Override
    public String getException() {
        return "fixed response";
    }
}
