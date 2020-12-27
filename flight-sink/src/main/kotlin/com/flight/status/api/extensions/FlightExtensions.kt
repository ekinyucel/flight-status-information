package com.flight.status.api.extensions

import com.flight.status.api.Flight

fun Flight.convertToFlightModel(): com.flight.status.api.model.Flight {
    return com.flight.status.api.model.Flight().apply {
        this.id = getId().toString()
        this.lastUpdateAt = lastUpdatedAt.toString()
        this.actualLandingTime = getActualLandingTime()?.toString()
        this.aircraftRegistration = getAircraftRegistration()?.toString()
        this.aircraftType = AircraftType().apply {
            this.iataMain = getAircraftType()?.iataMain.toString()
            this.iataSub = getAircraftType()?.iataSub.toString()
        }
        this.estimatedLandingTime = getEstimatedLandingTime()?.toString()
        this.flightDirection = getFlightDirection().toString()
        this.flightName = getFlightName().toString()
        this.gate = getGate()?.toString()
        this.pier = getPier()?.toString()
        this.isOperationalFlight = getIsOperationalFlight().toString()
        this.mainFlight = getMainFlight().toString()
        this.prefixIATA = getPrefixIATA().toString()
        this.airlineCode = getAirlineCode()
        this.route = Route().apply {
            this.eu = getRoute().eu.toString()
            this.visa = getRoute().visa.toString()
            this.destinations = getRoute().destinations
        }
        this.scheduleDateTime = getScheduleDateTime().toString()
        this.scheduleDate = getScheduleDate().toString()
        this.scheduleTime = getScheduleTime().toString()
    }
}