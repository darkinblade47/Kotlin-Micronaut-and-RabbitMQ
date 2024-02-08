package maven.rabbit

import io.micronaut.rabbitmq.annotation.Queue
import io.micronaut.rabbitmq.annotation.RabbitListener
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@RabbitListener
class RabbitListener {
    private val LOG: Logger = LoggerFactory.getLogger("logger")

    @Queue("buttonapp.queue")
    fun receive(data: ByteArray) {
        val string = String(data)
        val request = ClickRequest()
        request.setString(string)
        LOG.info("Iepurele a primit mesaj de la: $string")
        handler.accept(request)

    }

    companion object {
        val handler = ClickFunction()
    }
}