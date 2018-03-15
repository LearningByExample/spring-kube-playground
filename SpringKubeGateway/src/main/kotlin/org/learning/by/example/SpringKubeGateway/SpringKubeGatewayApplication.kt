package org.learning.by.example.SpringKubeGateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.DiscoveryClient
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.cloud.gateway.route.builder.routes
import org.springframework.context.annotation.Bean
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator


@SpringBootApplication
@EnableDiscoveryClient
class SpringKubeGatewayApplication {

  @Bean
  fun discoveryClientRouteLocator(discoveryClient: DiscoveryClient) =
      DiscoveryClientRouteDefinitionLocator(discoveryClient)

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
