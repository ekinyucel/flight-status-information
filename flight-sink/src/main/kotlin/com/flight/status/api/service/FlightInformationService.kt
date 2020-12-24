package com.flight.status.api.service

import com.flight.status.api.Flight
import com.flight.status.api.repository.FlightInformationReactiveRepository
import org.springframework.stereotype.Service
import javax.annotation.Resource

@Service
class FlightInformationService {

    @Resource
    private lateinit var flightInformationReactiveRepository: FlightInformationReactiveRepository

    fun saveFlight(flight: Flight) {
        flightInformationReactiveRepository.save(flight).subscribe { savedFlight -> println("a flight is saved $savedFlight.id") }
    }

}