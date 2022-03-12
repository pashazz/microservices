package com.example.helloeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class HelloeurekaserverApplication {

  public static void main(String[] args) {
    SpringApplication.run(HelloeurekaserverApplication.class, args);
  }

}
