package com.flight.status.api

import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Service
import java.util.function.Consumer

@Service
class Consumer {

    @Bean
    fun consumeFlightStatusInformation(): Consumer<Any> {
        return Consumer { s ->
            println("FLIGHT INFORMATION $s")
        }
    }

}