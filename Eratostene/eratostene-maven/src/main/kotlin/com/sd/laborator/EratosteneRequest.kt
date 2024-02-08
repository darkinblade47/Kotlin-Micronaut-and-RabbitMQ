package com.sd.laborator

import io.micronaut.core.annotation.Introspected
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Introspected
class EratosteneRequest {
    private var anything: List<Integer> = ArrayList<Integer>()

    fun getAnything(): List<Int> {
        val rezultat:MutableList<Int> = mutableListOf()
        anything.forEach {
            rezultat.add(it.toInt())
        }
        return rezultat
    }
}