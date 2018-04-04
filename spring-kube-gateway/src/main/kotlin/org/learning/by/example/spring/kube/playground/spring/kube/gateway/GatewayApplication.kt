package org.learning.by.example.spring.kube.playground.spring.kube.gateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.DiscoveryClient
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator
import org.springframework.context.annotation.Bean


@SpringBootApplication
@EnableDiscoveryClient
class GatewayApplication {

  @Bean
  fun discoveryClientRouteLocator(discoveryClient: DiscoveryClient) =
      DiscoveryClientRouteDefinitionLocator(discoveryClient)

}
