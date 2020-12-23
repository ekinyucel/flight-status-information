package io.flight.status.producer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FlightStatusApiApplication

fun main(args: Array<String>) {
    runApplication<FlightStatusApiApplication>(*args)
}