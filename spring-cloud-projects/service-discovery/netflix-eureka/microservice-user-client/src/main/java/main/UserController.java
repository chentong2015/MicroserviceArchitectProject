package main;

import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    // TODO. Spring Cloud提供的服务注册的登记信息
    @Resource
    Registration registration;

    private final UserService userService = new UserService();

    // URL中传递的路径参数需要指定具体的名称
    @GetMapping("/user/{id}")
    public String getOrderById(@PathVariable("id") int id) {
        return this.userService.getUserById(id);
    }

    // 获取当前服务所在的host主机的地址
    @GetMapping("/user/getIp")
    public String getTargetIp() {
        return "Address= " + this.registration.getHost() + ":" + this.registration.getPort();
    }
}
