package coada.service
import jakarta.inject.Singleton
import java.io.File

@Singleton
class QueueService {
    private var numbers:MutableList<Int> = mutableListOf()

    fun readNumbers(fileName:String):List<Int>{
        val line: List<String> =File(fileName).bufferedReader().readLines()
        val splitted=line[0].split(" ")
        for (it in splitted){
            numbers.add(it.toInt())
        }
        return numbers
    }
}