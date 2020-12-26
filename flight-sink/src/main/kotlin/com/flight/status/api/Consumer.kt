package com.flight.status.api

import com.flight.status.api.service.FlightInformationService
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Service
import java.util.function.Consumer
import javax.annotation.Resource

/**
 * A consumer class which retrieves flight information data from Kafka topic
 */
@Service
class Consumer {

    @Resource
    private lateinit var flightInformationService: FlightInformationService

    /**
     * A consumer function which fetches flight information data from Kafka topic and saves flight data to mongodb
     *
     * @return returning the Flights response as a consumer
     */
    @Bean
    fun consumeFlightStatusInformation(): Consumer<Flights> {
        return Consumer { flights: Flights ->
            flights.flights.forEach { flight ->
                flightInformationService.saveFlight(flight)
            }
        }
    }

}