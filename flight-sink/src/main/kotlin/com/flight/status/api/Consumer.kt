package com.flight.status.api

import com.flight.status.api.service.FlightInformationService
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Service
import java.util.function.Consumer
import javax.annotation.Resource

@Service
class Consumer {

    @Resource
    private lateinit var flightInformationService: FlightInformationService

    @Bean
    fun consumeFlightStatusInformation(): Consumer<Flights> {
        return Consumer { flights: Flights ->
            flights.flights.forEach { flight ->
                flightInformationService.saveFlight(flight)
            }
        }
    }

}