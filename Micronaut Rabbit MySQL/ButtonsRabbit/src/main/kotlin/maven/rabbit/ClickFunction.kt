package maven.rabbit;

import io.micronaut.function.FunctionBean
import io.micronaut.function.executor.FunctionInitializer
import jakarta.inject.Inject
import java.util.function.Consumer

@FunctionBean("button")
class ClickFunction : FunctionInitializer(), Consumer<ClickRequest> {

    @Inject
    private lateinit var clickService: ClickService

    override fun accept(t: ClickRequest) {
        val data = t.getString()
        clickService.updateButtonClicks(data)
    }
}

fun main(args: Array<String>) {
    val function = ClickFunction()
    function.run(args) { context ->
        function.accept(context.get(ClickRequest::class.java))
    }
}