package org.learning.by.example.spring.kube.playground.simple.microservice

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.toMono
import java.util.*

@Component
class SimpleHandler(val simpleService: SimpleService) {
  companion object {
    val id = UUID.randomUUID().toString()
  }

  fun getHello(serverRequest: ServerRequest) = ServerResponse.ok()
      .body(SimpleResponse(simpleService.getMessage(), id).toMono())

}
