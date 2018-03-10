package org.learning.by.example.SpringKubeGateway.SimpleMicroservice.SimpleMicroservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SimpleMicroserviceApplication

fun main(args: Array<String>) {
  runApplication<SimpleMicroserviceApplication>(*args)
}
