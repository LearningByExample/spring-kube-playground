package org.learning.by.example.SpringKubeGateway.SimpleMicroservice

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.toMono

@Component
class SimpleHandler(val simpleService: SimpleService) {

  fun getHello(serverRequest: ServerRequest) = ServerResponse.ok()
      .body(SimpleResponse(simpleService.getMessage()).toMono())

}
