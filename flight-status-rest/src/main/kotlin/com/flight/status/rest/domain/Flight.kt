package com.flight.status.rest.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

/**
 * A flight type document object
 */
@Document
class Flight {
    @Id
    var id: String? = null
    var flightName: String? = null
}