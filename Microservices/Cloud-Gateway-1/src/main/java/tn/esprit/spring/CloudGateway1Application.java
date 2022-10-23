package tn.esprit.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudGateway1Application {

	public static void main(String[] args) {
		SpringApplication.run(CloudGateway1Application.class, args);
	}

}
