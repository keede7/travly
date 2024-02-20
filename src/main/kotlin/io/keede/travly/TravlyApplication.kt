package io.keede.travly

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TravlyApplication

fun main(args: Array<String>) {
	runApplication<TravlyApplication>(*args)
}
