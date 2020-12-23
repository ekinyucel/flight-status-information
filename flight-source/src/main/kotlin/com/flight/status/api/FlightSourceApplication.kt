package com.flight.status.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FlightSourceApplication

fun main(args: Array<String>) {
	runApplication<FlightSourceApplication>(*args)
}
