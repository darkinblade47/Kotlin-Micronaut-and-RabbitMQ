package maven.rabbit


import io.micronaut.core.annotation.Introspected

@Introspected
class ClickRequest {
    private lateinit var string: String

    fun getString(): String {
        return string
    }

    fun setString(s: String) {
        this.string = s
    }
}