package io.flight.status.api

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.net.URI
import java.util.function.Supplier
import javax.annotation.Resource

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

    @Resource
    private lateinit var objectMapper: ObjectMapper

    @Resource
    private lateinit var restTemplate: RestTemplate

    @Bean
    fun produceFlightStatusInformation(): Supplier<Flights?> {
        var flights: Flights? = null
        val uri = URI("$flightStatusApi?scheduleDate=2020-11-29&includedelays=false&page=0&sort=-scheduleTime&fromDateTime=2020-11-29T14:50:00&toDateTime=2020-11-29T17:50:00&searchDateTimeField=scheduleDateTime")
        val headers = HttpHeaders().apply {
            set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
            set("app_id", applicationId)
            set("app_key", applicationKey)
            set("ResourceVersion", flightStatusApiVersion)
        }
        val requestEntity = HttpEntity(null, headers)
        val result = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String::class.java)

        if (result.statusCode.is2xxSuccessful) {
            val body = result.body
            flights = objectMapper.readValue(body, Flights::class.java)
        }

        return Supplier {
            flights
        }
    }
}