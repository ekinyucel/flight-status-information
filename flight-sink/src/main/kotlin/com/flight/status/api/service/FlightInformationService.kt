package com.flight.status.api.service

import com.flight.status.api.model.Flight
import com.flight.status.api.repository.FlightInformationReactiveRepository
import org.springframework.stereotype.Service
import javax.annotation.Resource

/**
 * Flight information service for mongo related operations
 */
@Service
class FlightInformationService {

    @Resource
    private lateinit var flightInformationReactiveRepository: FlightInformationReactiveRepository

    /**
     * A function for saving flight element to database
     *
     * @param flight element
     */
    fun saveFlight(flight: Flight) {
        flightInformationReactiveRepository.save(flight).subscribe { savedFlight -> println("a flight is saved $savedFlight.id") }
    }

}