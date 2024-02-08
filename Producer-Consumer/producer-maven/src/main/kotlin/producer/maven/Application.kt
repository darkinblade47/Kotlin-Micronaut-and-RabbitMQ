package producer.maven

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.runtime.Micronaut
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object Application {
    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.run(Application::class.java, *args)

    }

    @Controller
    class LambdaController {
        @Post
        fun execute(): ProducerResponse {
            val xml=handler.get().getXml()
            khttp.post(url = "http://localhost:8081/", headers = mapOf("Content-Type" to "application/json"), data = "{\"xml\": \"$xml\" }")
            return handler.get()
        }
        companion object {
            private val handler = ProducerFunction()
        }
    }

}