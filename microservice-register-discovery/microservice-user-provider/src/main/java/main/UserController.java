package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class UserController {

    // 从注册环境中获取server启动的端口
    @Autowired
    private Environment environment;

    private final UserService userService = new UserService();

    // URL中传递的路径参数需要指定具体的名称
    @GetMapping("/user/{id}")
    public String getOrderById(@PathVariable("id") int id) {
        return this.userService.getUserById(id);
    }

    @GetMapping("/user/getIp")
    public String getTargetIp() throws UnknownHostException {
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = environment.getProperty("local.server.port");
        return "ip address= " + ip + ":" + port;
    }
}
