package org.learning.by.example.SpringKubeGateway

import org.assertj.core.api.Assertions.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.Mockito.reset
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.test.mock.mockito.SpyBean
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.cloud.client.DefaultServiceInstance
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient
import org.springframework.http.HttpStatus
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.reactive.server.WebTestClient


@RunWith(SpringRunner::class)
@SpringBootTest(classes = [GatewayApplication::class, FakeEndPoint::class],
    webEnvironment = RANDOM_PORT, properties = [
  "eureka.client.enabled=false",
  "spring.cloud.discovery.client.simple.instances.simplemicroservice[0].uri=http://localhost"])
@ActiveProfiles("test")
class GatewayIntegrationTests {

  @LocalServerPort
  protected var port = 0

  lateinit var testClient: WebTestClient
  lateinit var baseUri: String

  @SpyBean
  lateinit var loadBalancerClient: LoadBalancerClient

  @Before
  fun setup() {
    this.baseUri = "http://localhost:$port"
    this.testClient = WebTestClient.bindToServer().baseUrl(baseUri).build()

    val serviceInstance = DefaultServiceInstance("simplemicroservice", "localhost", port, true)
    given(loadBalancerClient.choose("simplemicroservice")).willReturn(serviceInstance)
  }

  @After
  fun tearDown() {
    reset(loadBalancerClient)
  }

  @Test
  fun requestingSimpleMicroServiceShouldWork() {
    val body = testClient.get()
        .uri("/simplemicroservice/hello")
        .exchange()
        .expectStatus().isEqualTo(HttpStatus.OK)
        .expectBody(String::class.java)
        .returnResult().responseBody

    assertThat(body).isEqualTo("world")
  }

}
