package org.learning.by.example.SpringKubeGateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.cloud.gateway.route.builder.routes
import org.springframework.context.annotation.Bean

@SpringBootApplication
class SpringKubeGatewayApplication {

  @Bean
  fun routes(routes: RouteLocatorBuilder) = routes.routes {
    route {
      path("/hello")
      uri("lb://simplemicroservice/hello")
    }
  }

}

fun main(args: Array<String>) {
  runApplication<SpringKubeGatewayApplication>(*args)
}
