package org.learning.by.example.spring.kube.playground.spring.kube.gateway

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import org.springframework.web.reactive.function.server.router
import reactor.core.publisher.toMono

fun getHello(serverRequest: ServerRequest) = ServerResponse.ok()
        .body("world".toMono())

@Configuration
class FakeEndPoint {
    @Bean
    fun routes() = router {
        "/hello".nest {
            GET("/", ::getHello)
        }
    }
}