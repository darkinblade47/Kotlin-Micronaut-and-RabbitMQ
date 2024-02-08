package producer.maven
import io.micronaut.core.annotation.Introspected

@Introspected
class ProducerResponse {
    private var xml:String? = null

    fun getXml():String?{
        return xml
    }

    fun setXml(xml:String?){
        this.xml=xml
    }
}