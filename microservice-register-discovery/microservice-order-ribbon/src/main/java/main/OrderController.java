package main;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    // TODO. 通过服务发现调用到指定服务名称的service，实现微服务之间的负载均衡
    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/order/{id}")
    public String getOrderById(@PathVariable("id") int id) {
        // restTemplate.getForObject("http://localhost:8001", String.class);
        return "id=" + id;
    }

    // 测试负载均衡到的指定服务IP
    @GetMapping("/order/getIp")
    public String getTargetIp() {
        return "ip address";
    }
}
