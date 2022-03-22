package com.springcloud.openfeign.base;

import org.bouncycastle.util.Store;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

// 作为客户端而言，只是向指定的API发送数据，拿到返回的信息
@FeignClient("stores")
public interface StoreFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/stores")
    List<Store> getStores();

    // @RequestMapping(method = RequestMethod.GET, value = "/stores")
    // Page<Store> getStores(SpringDataWebProperties.Pageable pageable);

    @RequestMapping(method = RequestMethod.POST, value = "/stores/{storeId}", consumes = "application/json")
    Store update(@PathVariable("storeId") Long storeId, Store store);

    @RequestMapping(method = RequestMethod.DELETE, value = "/stores/{storeId:\\d+}")
    void delete(@PathVariable Long storeId);
}
