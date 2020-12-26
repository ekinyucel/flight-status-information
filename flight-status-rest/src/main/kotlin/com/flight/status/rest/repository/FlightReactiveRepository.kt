package com.flight.status.rest.repository

import com.flight.status.rest.domain.Flight
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.reactive.asFlow
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface FlightReactiveRepository: ReactiveMongoRepository<Flight, String> {

}