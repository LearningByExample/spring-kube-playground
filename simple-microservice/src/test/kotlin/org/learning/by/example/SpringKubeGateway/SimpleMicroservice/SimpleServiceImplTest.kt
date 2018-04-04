package org.learning.by.example.SpringKubeGateway.SimpleMicroservice

import org.amshove.kluent.`should be greater or equal to`
import org.amshove.kluent.`should be in`
import org.amshove.kluent.`should be less or equal to`
import org.amshove.kluent.`should not be blank`
import org.junit.Test

class SimpleServiceImplTest : SimpleServiceImpl() {

  @Test
  fun `we should return a valid message`() {
    val simpleServiceImpl = SimpleServiceImpl()
    val message = simpleServiceImpl.getMessage()

    message.`should not be blank`()
    message `should be in` SimpleServiceImpl.salutes
  }

  @Test
  fun `random a close range should work for 10 randoms`() {

    val intRange = 5..10

    (1..10).forEach {
      val randomValue = intRange.random()

      randomValue `should be in` intRange
      randomValue `should be greater or equal to` intRange.start
      randomValue `should be less or equal to` intRange.endInclusive
    }

  }

  @Test
  fun `random a array list should work for 10 randoms`() {

    val arrayList = arrayListOf("one", "two", "three")

    (1..10).forEach {
      arrayList.random() `should be in` arrayList
    }

  }

}
