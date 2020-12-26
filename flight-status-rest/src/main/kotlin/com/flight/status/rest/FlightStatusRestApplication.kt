package com.flight.status.rest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FlightStatusRestApplication

fun main(args: Array<String>) {
	runApplication<FlightStatusRestApplication>(*args)
}
