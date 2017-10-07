package eu.finki.smite

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class Application {

    companion object {
        fun main(args: Array<String>) {
            SpringApplication.run(Application::class.java, *args)
        }
    }
}