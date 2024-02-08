package producer.maven
import jakarta.inject.Singleton
import java.io.File

@Singleton
class ProducerService {

    private lateinit var xml:String

    fun getAndSendXml(url:String):String{
        val r = khttp.get(url)
        var replaced=r.text.replace("\n","")
        replaced=replaced.replace("\"","\\\"")

        return replaced
    }

}