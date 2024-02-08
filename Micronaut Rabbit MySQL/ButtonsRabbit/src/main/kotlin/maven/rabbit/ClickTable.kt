package maven.rabbit

import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity

@MappedEntity
data class ClickTable(
    @field:Id
    @field:GeneratedValue(GeneratedValue.Type.AUTO)
    var id: Int,
    var button_name: String,
    var clicks: Int
)