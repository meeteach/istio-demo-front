package com.pay.istio.demo.front;

import java.net.UnknownHostException;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author niuyandong
 * @since 2018年4月6日 下午3:41:57
 */
@SpringBootApplication
@Configuration
public class HelloworldApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(HelloworldApplication.class, args);
    }
    
}

@RestController
class HelloworldController {
    
    private String endpoint = "http://helloworld-service:8080/hello";
    private final RestTemplate restTemplate = new RestTemplate();
    
    @GetMapping("/hello/{name}")
    public Map<String, String> hello(@PathVariable String name)
        throws UnknownHostException {
        String ep = endpoint + "/" + name;
        
        return restTemplate.getForObject(ep, Map.class);
    }
}
