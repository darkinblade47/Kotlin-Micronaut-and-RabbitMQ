package consumer.maven
import io.micronaut.core.annotation.Introspected

@Introspected
class ConsumerRequest {
    private lateinit var xml: String

    fun getXml(): String {
        return xml
    }
}