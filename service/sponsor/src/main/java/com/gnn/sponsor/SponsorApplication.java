package com.gnn.sponsor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients //可以调用其他服务的api
@EnableCircuitBreaker //断路器
@EnableEurekaClient
public class SponsorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SponsorApplication.class, args);
	}

}
