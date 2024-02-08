package producer.maven

import io.micronaut.function.FunctionBean
import io.micronaut.function.executor.FunctionInitializer
import jakarta.inject.Inject
import java.util.function.Supplier

@FunctionBean("producer")
class ProducerFunction : FunctionInitializer(), Supplier<ProducerResponse> {

    @Inject
    private lateinit var producerService: ProducerService

    override fun get(): ProducerResponse {
        val res= ProducerResponse()
        res.setXml(producerService.getAndSendXml("https://xkcd.com/atom.xml"))
        return res
    }
}

fun main(args : Array<String>) {
    val function = ProducerFunction()
    function.run(args, { context ->
        function.get()})
}