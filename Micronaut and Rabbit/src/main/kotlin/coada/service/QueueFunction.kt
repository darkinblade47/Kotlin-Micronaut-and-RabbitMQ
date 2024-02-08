package coada.service

import io.micronaut.function.FunctionBean
import io.micronaut.function.executor.FunctionInitializer
import jakarta.inject.Inject
import java.util.function.Supplier

@FunctionBean("queue")
class QueueFunction : FunctionInitializer(), Supplier<QueueResponse> {

    @Inject
    private lateinit var queueService: QueueService

    override fun get(): QueueResponse {
        val res= QueueResponse()
        res.setNumbers(queueService.readNumbers("/home/darkinblade/SD/Tema11/coada-service/src/main/kotlin/coada/service/queue.txt"))
        return res
    }
}

fun main(args : Array<String>) {
    val function = QueueFunction()
    function.run(args, { context ->
        function.get()})
}