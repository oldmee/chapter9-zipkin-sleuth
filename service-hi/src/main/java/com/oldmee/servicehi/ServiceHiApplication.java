package com.oldmee.servicehi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@RestController
public class ServiceHiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceHiApplication.class, args);
    }

    Logger logger = LoggerFactory.getLogger("ServiceHiApplication");

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }


    @RequestMapping("hi")
    public String callOther() {
        logger.info("calling trace service-hi");
        return restTemplate.getForObject("http://localhost:8989/otherCallingMiya", String.class);
    }


    @RequestMapping("otherCallingHi")
    public String callMe() {
        logger.info("service-miya call me");
        return "i'm service-hi";
    }

}
