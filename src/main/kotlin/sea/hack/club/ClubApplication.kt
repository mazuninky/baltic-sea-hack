package sea.hack.club

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ClubApplication

fun main(args: Array<String>) {
	runApplication<ClubApplication>(*args)
}
