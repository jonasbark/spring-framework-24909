package pass.users.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.function.router
import javax.annotation.PostConstruct

@SpringBootApplication(
    scanBasePackageClasses = [PassUsersAPI::class]
)
class PassUsersAPI {
    @PostConstruct
    fun afterConstruct() {
    }
}


@Suppress("SpreadOperator")
fun main(args: Array<String>) {
    runApplication<PassUsersAPI>(*args)
}


@Configuration
class Routes {

    @Suppress("LongParameterList")
    @Bean
    fun routingUser() = router {

        POST("/user-photo/") {
            println(it.servletRequest().parts)
            ok().build()
        }

    }
}
