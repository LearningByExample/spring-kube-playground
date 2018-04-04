package org.learning.by.example.SpringKubeGateway.SimpleMicroservice

import reactor.core.publisher.Mono

interface SimpleService {

  fun getMessage(): String

}
