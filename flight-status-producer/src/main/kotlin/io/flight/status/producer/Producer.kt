package io.flight.status.producer

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
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
    fun produceFlightStatusInformation(): Supplier<io.flight.status.producer.Flights?> {
        val uri = URI("$flightStatusApi?scheduleDate=2020-11-29&includedelays=false&page=0&sort=-scheduleTime&fromDateTime=2020-11-29T14:50:00&toDateTime=2020-11-29T17:50:00&searchDateTimeField=scheduleDateTime")

        val webClient = WebClient.builder()
                .baseUrl(uri.toString())
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader("app_id", applicationId)
                .defaultHeader("app_key", applicationKey)
                .defaultHeader("ResourceVersion", flightStatusApiVersion)
                .build()

        val result = webClient.get()
                .retrieve()
                .bodyToFlux(io.flight.status.producer.Flights::class.java)
                .toStream().collect(Collectors.toList())

        return Supplier {
            result[0]
        }
    }
}