package com.example.clientservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class ClientServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientServicesApplication.class, args);
    }

}
