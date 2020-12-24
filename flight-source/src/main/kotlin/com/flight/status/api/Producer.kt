package com.flight.status.api

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI
import java.util.function.Supplier
import java.util.stream.Collectors

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

    @Bean
    fun produceFlightStatusInformation(): Supplier<Flights?> {
        val uri = UriComponentsBuilder.fromUriString(flightStatusApi)
                .queryParam("scheduleDate", "2020-11-29")
                .queryParam("includedelays", "false")
                .queryParam("page", 0)
                .queryParam("sort", "-scheduleTime")
                .queryParam("fromDateTime", "2020-11-29T14:50:00")
                .queryParam("toDateTime", "2020-11-29T17:50:00")
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
                .toStream().collect(Collectors.toList())

        return Supplier {
            result[0]
        }
    }

}