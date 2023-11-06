package com.springcloud.openfeign.client;

@RetryableFeignClient(name = "retryable-client")
public interface RetryableFeignClientInterface {


}
