package coada.service
import io.micronaut.core.annotation.Introspected

@Introspected
class QueueResponse {
    private var queue:List<Int>? = null

    fun getNumbers():List<Int>?{
        return queue
    }

    fun setNumbers(queue:List<Int>?){
        this.queue=queue
    }
}