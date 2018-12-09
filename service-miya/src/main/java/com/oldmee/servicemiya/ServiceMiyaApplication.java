package com.oldmee.servicemiya;

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
public class ServiceMiyaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceMiyaApplication.class, args);
    }

    private Logger logger = LoggerFactory.getLogger("ServiceMiyaApplication");


    @Autowired
    private RestTemplate restTemplate;


    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }


    @RequestMapping("callingTohi")
    public String callOther() {
        logger.info("miya call other");
        return restTemplate.getForObject("http://localhost:8988/otherCallingHi", String.class);
    }

    @RequestMapping("otherCallingMiya")
    public String callMe() {
        logger.info("otherCallingMiya");
        return "I'm service miya";
    }

}
