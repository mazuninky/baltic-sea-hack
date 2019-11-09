package sea.hack.club

import org.springframework.boot.autoconfigure.SpringBootApplication
import java.util.HashMap
import org.springframework.core.env.StandardEnvironment
import org.springframework.boot.builder.SpringApplicationBuilder


@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
    // Костыль, чтобы игнорировать проперти на сервере из ENV
    val applicationBuilder = SpringApplicationBuilder(DemoApplication::class.java)
            .environment(object : StandardEnvironment() {
                override fun getSystemEnvironment(): Map<String, Any> {
                    return HashMap()
                }

                override fun getSystemProperties(): Map<String, Any> {
                    return HashMap()
                }
            })
    applicationBuilder.run(*args)
}
