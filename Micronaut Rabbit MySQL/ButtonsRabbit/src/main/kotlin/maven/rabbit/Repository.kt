package maven.rabbit

import io.micronaut.data.annotation.Id
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.PageableRepository
import jakarta.inject.Singleton
import javax.validation.constraints.NotBlank

@Singleton
@JdbcRepository(dialect = Dialect.MYSQL)
abstract class Repository : PageableRepository<ClickTable, Long> {

    abstract fun update(@Id id: Int, @NotBlank button_name: String, @NotBlank clicks: Int): Int
}