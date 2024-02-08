package consumer.maven
import jakarta.inject.Singleton
import org.jsoup.Jsoup
import org.jsoup.select.Elements

@Singleton
class ConsumerService {

    fun getAndSendXml(url:String):Map<String,String>{
        val table:MutableMap<String,String> = mutableMapOf()
        val xml= Jsoup.parse(url)
        val titles:Elements=xml.select("title")
        val hrefs:Elements=xml.select("link")

        for(it in 0 until titles.size)
        {
            table[titles[it].text()] = hrefs[it].attr("href")
        }

        return table
    }

}