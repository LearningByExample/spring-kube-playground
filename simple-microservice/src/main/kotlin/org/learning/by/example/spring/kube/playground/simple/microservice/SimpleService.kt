package org.learning.by.example.spring.kube.playground.simple.microservice

import reactor.core.publisher.Mono

interface SimpleService {

  fun getMessage(): String

}
