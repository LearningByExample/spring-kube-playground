package org.learning.by.example.spring.kube.playground.simple.microservice

import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.reset
import com.nhaarman.mockito_kotlin.whenever
import org.amshove.kluent.`should equal to`
import org.amshove.kluent.mock
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.SpyBean
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.web.reactive.function.server.EntityResponse
import reactor.core.publisher.Mono

@RunWith(SpringRunner::class)
@SpringBootTest(classes = [Application::class])
@ActiveProfiles("test")
class SimpleHandlerTest{

  @Autowired
  lateinit var simpleHandler: SimpleHandler

  @SpyBean
  lateinit var simpleService: SimpleService

  @Suppress("UNCHECKED_CAST")
  @Test
  fun `handler should return a valid message`(){
    doReturn("world").whenever(simpleService).getMessage()

    val (message, from) = (simpleHandler.getHello(mock()).block() as EntityResponse<Mono<SimpleResponse>>)
        .entity().block()!!

    from `should equal to` SimpleHandler.id
    message `should equal to` "world"

    reset(simpleService)
  }

}
