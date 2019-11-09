package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.HashMap
import org.springframework.core.env.StandardEnvironment
import org.springframework.boot.builder.SpringApplicationBuilder


@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
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
