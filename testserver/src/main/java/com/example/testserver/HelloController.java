package com.example.testserver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@Slf4j
public class HelloController {

  @Autowired
  private ServletWebServerApplicationContext server;

  @RequestMapping(method = RequestMethod.GET, path = "/hello/{text}")
  public ResponseEntity<HelloEntity> hello(@PathVariable("text") String text) {
    int port = server.getWebServer().getPort();

    log.info("Returning text: " + text);
    log.info("Running on port " + port);
    return ResponseEntity.of(Optional.of(new HelloEntity(String.format("Hello, %s", text), port)));
  }
}
