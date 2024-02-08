package com.sd.laborator

import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.runtime.Micronaut

object Application {
    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.run(Application::class.java, *args)
    }

    @Controller
    class LambdaController {
        @Post
        fun execute(@Body parseRequest: EratosteneRequest): EratosteneResponse {
            return handler.apply(parseRequest)
        }

        companion object {
            private val handler = EratosteneFunction()
        }
    }
}