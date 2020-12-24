package com.flight.status.api.repository

import com.flight.status.api.Flight
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface FlightInformationReactiveRepository: ReactiveMongoRepository<Flight, String> {
}
