package com.flight.status.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FlightSinkApplication

fun main(args: Array<String>) {
	runApplication<FlightSinkApplication>(*args)
}
