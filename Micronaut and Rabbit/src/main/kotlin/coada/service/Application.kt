package coada.service

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.server.netty.types.stream.NettyStreamedCustomizableResponseType.LOG
import io.micronaut.runtime.Micronaut
import java.io.DataOutputStream
import java.net.URL

object Application {
    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.run(Application::class.java, *args)
    }

    @Controller
    class LambdaController {
        @Post
        fun get(): QueueResponse {
            val list= handler.get().getNumbers()
            khttp.post(url = "http://localhost:8081/", headers = mapOf("Content-Type" to "application/json"), data = "{\"anything\": ${list}}")
            return handler.get()
        }
        companion object {
            private val handler = QueueFunction()
        }
    }
}