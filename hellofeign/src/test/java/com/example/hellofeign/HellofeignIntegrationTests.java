package com.example.hellofeign;

import com.example.hellofeign.api.HelloWorldClient;
import com.example.hellofeign.entity.HelloEntity;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HellofeignIntegrationTests {
  private final String SERVICE_NAME = "hello-world";

  @Autowired
  private HelloWorldClient client;


  @Autowired
  private DiscoveryClient discoveryClient;

  @Test
  void testCanDiscoverService() {
    var services = discoveryClient.getServices();

    var instances = discoveryClient.getInstances("hello-world");
    assertThat(instances).has(new Condition<>() {
      @Override
      public boolean matches(List<ServiceInstance> value) {
        return value.size() > 0;
      }
    });
  }

  @Test
  void testHelloWorld() {
    HelloEntity entity = client.hello("World!");
    System.out.println(entity);
    assertThat(entity.getText()).isEqualTo("Hello, World!");
  }



}
