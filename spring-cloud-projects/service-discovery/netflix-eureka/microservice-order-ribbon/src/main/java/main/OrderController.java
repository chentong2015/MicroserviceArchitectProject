package main;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    @Autowired
    private EurekaClient discoveryClient;
    @Autowired
    RestTemplate restTemplate;

    //TODO. 通过"微服务名"来从注册中心发现特定的服务，然后LB负载均衡调用
    @GetMapping("/order/{id}")
    public String getOrderById(@PathVariable("id") int id) {
        String user = restTemplate.getForObject("http://user-service/user/" + id, String.class);
        return "Order with user:" + user;
    }

    @GetMapping("/order/getTargetIp")
    public String getTargetIp() {
        String ip = restTemplate.getForObject("http://user-service/user/getIp", String.class);
        return "Target IP:" + ip;
    }

    // 测试负载均衡获取到的下一个服务的地址IP
    @GetMapping("/order/getNextIp")
    public String getNextIp() {
        InstanceInfo instance = this.discoveryClient.getNextServerFromEureka("user-service", false);
        return instance.getHomePageUrl();
    }
}
