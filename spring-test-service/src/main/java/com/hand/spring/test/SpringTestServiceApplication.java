package com.hand.spring.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients({"com.hand.service"})
//@EnableScheduling  // 开启定时任务
public class SpringTestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringTestServiceApplication.class, args);
	}
}
