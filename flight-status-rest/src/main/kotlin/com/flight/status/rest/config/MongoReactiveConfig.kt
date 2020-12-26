package com.flight.status.rest.config

import com.mongodb.ConnectionString
import com.mongodb.reactivestreams.client.MongoClient
import com.mongodb.reactivestreams.client.MongoClients
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.SimpleReactiveMongoDatabaseFactory
import org.springframework.data.mongodb.core.convert.MappingMongoConverter
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@Configuration
@EnableReactiveMongoRepositories(basePackages = ["com.flight.status.rest.repository"])
class MongoReactiveConfig: AbstractReactiveMongoConfiguration() {

    @Value("\${spring.data.mongodb.uri}")
    private lateinit var mongoServerUrl: String

    @Bean
    override fun reactiveMongoDbFactory(): ReactiveMongoDatabaseFactory {
        return SimpleReactiveMongoDatabaseFactory(ConnectionString(mongoServerUrl))
    }

    override fun reactiveMongoTemplate(databaseFactory: ReactiveMongoDatabaseFactory, mongoConverter: MappingMongoConverter): ReactiveMongoTemplate {
        return super.reactiveMongoTemplate(reactiveMongoDbFactory(), mongoConverter)
    }

    override fun reactiveMongoClient(): MongoClient {
        return MongoClients.create()
    }

    override fun getDatabaseName(): String {
        return "flightinformation"
    }
}