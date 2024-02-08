package maven.rabbit

import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class ClickService {
    @Inject
    private lateinit var repo: Repository

    fun updateButtonClicks(button: String) {
        val buttonId: Int = button[6].toString().toInt()
        val dbButton = repo.findById(buttonId.toLong()).get()
        dbButton.id.let { repo.update(it, dbButton.button_name, dbButton.clicks + 1) }
    }
}