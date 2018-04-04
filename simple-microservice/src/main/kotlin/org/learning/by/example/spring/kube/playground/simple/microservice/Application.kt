package org.learning.by.example.spring.kube.playground.simple.microservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class Application {

  @Bean
  fun simpleService(): SimpleService = SimpleServiceImpl()

}
