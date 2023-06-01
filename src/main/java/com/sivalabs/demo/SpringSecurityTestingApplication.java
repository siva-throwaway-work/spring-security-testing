package com.sivalabs.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class SpringSecurityTestingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityTestingApplication.class, args);
    }

}
