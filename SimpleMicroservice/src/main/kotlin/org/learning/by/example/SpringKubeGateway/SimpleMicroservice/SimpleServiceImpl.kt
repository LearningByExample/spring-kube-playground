package org.learning.by.example.SpringKubeGateway.SimpleMicroservice

import java.util.*

class SimpleServiceImpl : SimpleService {

  companion object {
    val salutes = arrayListOf("Hello", "Hola", "Bonjour", "Olá", "Hallo", "Hej", "Tere", "Ciao", "Hei")
  }

  private fun ClosedRange<Int>.random() = Random().nextInt(endInclusive - start) + start
  private fun <Type : Any> ArrayList<Type>.random() = this[(0..this.size).random()]

  override fun getMessage() = salutes.random()

}
