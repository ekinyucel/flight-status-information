package com.flight.status.rest.handler

import com.flight.status.rest.repository.FlightReactiveRepository
import kotlinx.coroutines.reactive.asFlow
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.bodyAndAwait

/**
 * Handling requests for flight endpoints
 */
@Component
class FlightHandler(private val flightReactiveRepository: FlightReactiveRepository) {

    /**
     * A handler function for returning the list of flights.
     *
     * @param request is a [ServerRequest]
     * @return a response as [ServerResponse] type
     */
    suspend fun listFlights(request: ServerRequest): ServerResponse {
        val flights = flightReactiveRepository.findAll().asFlow()
        return ok().contentType(MediaType.APPLICATION_JSON).bodyAndAwait(flights)
    }

}