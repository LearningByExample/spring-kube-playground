package org.learning.by.example.spring.kube.playground.simple.microservice

import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.router

@Component
class SimpleRouter(val simpleHandler: SimpleHandler) {

  @Bean
  fun routes() = router {
    "/hello".nest {
      GET("/", simpleHandler::getHello)
    }
  }

}
