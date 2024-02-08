package consumer.maven

import io.micronaut.function.FunctionBean
import io.micronaut.function.executor.FunctionInitializer
import jakarta.inject.Inject
import java.util.function.Consumer

@FunctionBean("consumer")
class ConsumerFunction : FunctionInitializer(), Consumer<ConsumerRequest> {

    @Inject
    private lateinit var consumerService: ConsumerService

    override fun accept(t: ConsumerRequest) {
        val xml=t.getXml()
        val map=consumerService.getAndSendXml(xml)
        println("Map-ul de tip <TTILE:URL>")
        for ((key, value) in map) {
            println("$key : $value")
        }
    }
}

fun main(args : Array<String>) {
    val function = ConsumerFunction()
    function.run(args) { context ->
        function.accept(context.get(ConsumerRequest::class.java))
    }
}