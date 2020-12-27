package com.flight.status.api.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

/**
 * A flight type document object
 */
@Document
class Flight {
    @Id
    var id: String? = null
    var lastUpdateAt: String? = null
    var actualLandingTime: String? = null
    var aircraftRegistration: String? = null
    var aircraftType: AircraftType? = null
    var estimatedLandingTime: String? = null
    var flightDirection: String? = null
    var flightName: String? = null
    var gate: String? = null
    var pier: String? = null
    var isOperationalFlight: String? = null
    var mainFlight: String? = null
    var prefixIATA: String? = null
    var airlineCode: Int = 0
    var route: Route? = null
    var scheduleDateTime: String? = null
    var scheduleDate: String? = null
    var scheduleTime: String? = null

    inner class AircraftType {
        var iataMain: String? = null
        var iataSub: String? = null
    }

    inner class Route {
        var destinations: List<CharSequence> = listOf()
        var eu: String? = null
        var visa: String? = null
    }
}