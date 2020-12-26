package com.flight.status.api

import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.function.context.PollableBean
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.util.UriComponentsBuilder
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.function.Supplier
import java.util.stream.Collectors

/**
 * A Flight status information producer which feeds the Kafka topic with relevant flight status information which is obtained from Schiphol API
 */
@Service
class Producer {

    @Value("\${flight-status.api}")
    private lateinit var flightStatusApi: String

    @Value("\${flight-status.version}")
    private lateinit var flightStatusApiVersion: String

    @Value("\${flight-status.app.id}")
    private lateinit var applicationId: String

    @Value("\${flight-status.app.key}")
    private lateinit var applicationKey: String

    /**
     * A function for retrieving the flight status information from schiphol API.
     * The retrieved flight status data is published to Kafka topic
     * Spring cloud stream invokes this function
     *
     * @return Flights as a supplier
     */
    @PollableBean
    fun produceFlightStatusInformation(): Supplier<Flights?> {
        val localDateTime = LocalDateTime.now().withNano(0)

        val uri = UriComponentsBuilder.fromUriString(flightStatusApi)
                .queryParam("scheduleDate", LocalDate.now())
                .queryParam("includedelays", "false")
                .queryParam("page", 0)
                .queryParam("sort", "-scheduleTime")
                .queryParam("fromDateTime", localDateTime.minusHours(4))
                .queryParam("toDateTime", localDateTime.plusHours(4))
                .queryParam("searchDateTimeField", "scheduleDateTime")
                .build().toString()

        val webClient = WebClient.builder()
                .baseUrl(uri)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader("app_id", applicationId)
                .defaultHeader("app_key", applicationKey)
                .defaultHeader("ResourceVersion", flightStatusApiVersion)
                .build()

        val result = webClient.get()
                .retrieve()
                .bodyToFlux(Flights::class.java)
                // change to coroutine
                .toStream().collect(Collectors.toList())

        return Supplier {
            result[0]
        }
    }

}