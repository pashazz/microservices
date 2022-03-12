package com.example.hellofeign.api;

import com.example.hellofeign.configuration.MyConfiguration;
import com.example.hellofeign.entity.HelloEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "HELLO-WORLD", configuration = MyConfiguration.class)
public interface HelloWorldClient {
  @GetMapping(path = "/hello/{text}", consumes = "application/json")
  HelloEntity hello(@PathVariable("text") String text);


}
