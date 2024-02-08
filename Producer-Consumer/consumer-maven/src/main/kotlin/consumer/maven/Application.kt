package consumer.maven

import io.micronaut.http.annotation.Body
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
        fun execute(@Body request: ConsumerRequest) {
            handler.accept(request)
        }
        companion object {
            private val handler = ConsumerFunction()
        }
    }

}