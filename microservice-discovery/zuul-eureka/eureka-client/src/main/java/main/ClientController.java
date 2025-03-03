package main;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Autowired
    @Lazy
    private EurekaClient eurekaClient;

    @Value("${spring.application.name}")
    private String appName;

    @Value("${server.port}")
    private String portNumber;

    @RequestMapping("/greeting")
    public String greeting() {
        System.out.println("Request received on port number " + portNumber);
        return String.format("Hello from '%s with Port Number %s'!",
                eurekaClient.getApplication(appName).getName(), portNumber);
    }
}
