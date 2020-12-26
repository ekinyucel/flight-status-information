package com.flight.status.rest.config

import com.flight.status.rest.handler.FlightHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.config.WebFluxConfigurer
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.coRouter

@Configuration
@EnableWebFlux
@ComponentScan("com.flight.status.rest.*")
class WebConfig: WebFluxConfigurer {

    /**
     * A defined bean for redirecting incoming requests to flight service
     *
     * @param flightHandler passing the class which has the handling logic
     * @return returning the [ServerResponse] as a [RouterFunction] type
     */
    @Bean
    fun flightRouterFunction(flightHandler: FlightHandler): RouterFunction<ServerResponse> {
        return coRouter {
            GET("/flights", accept(MediaType.APPLICATION_JSON), flightHandler::listFlights)
        }
    }

}