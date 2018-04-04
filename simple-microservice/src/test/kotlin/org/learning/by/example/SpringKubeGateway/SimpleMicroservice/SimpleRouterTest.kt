package org.learning.by.example.SpringKubeGateway.SimpleMicroservice

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.reset
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.SpyBean
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.toMono

@RunWith(SpringRunner::class)
@SpringBootTest(classes = [Application::class])
@ActiveProfiles("test")
class SimpleRouterTest {

  lateinit var testClient: WebTestClient

  @Autowired
  lateinit var simpleRouter: SimpleRouter

  @SpyBean
  lateinit var simpleHandler: SimpleHandler

  @Before
  fun setup() {
    testClient = WebTestClient.bindToRouterFunction(simpleRouter.routes()).build()
  }

  @Test
  fun `hello route should return a valid response`() {
    doReturn(ServerResponse.ok().body(SimpleResponse("hello", "world").toMono())).whenever(simpleHandler).getHello(any())

    testClient.get()
        .uri("/hello")
        .exchange()
        .expectStatus().isEqualTo(HttpStatus.OK)
        .expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
        .expectBody()
        .jsonPath("\$.message").isEqualTo("hello")
        .jsonPath("\$.from").isEqualTo("world")

    reset(simpleHandler)
  }

}
