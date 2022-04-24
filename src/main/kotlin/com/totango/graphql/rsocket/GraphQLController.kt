package com.totango.graphql.rsocket

import org.springframework.graphql.client.RSocketGraphQlClient
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.graphql.data.method.annotation.SubscriptionMapping
import org.springframework.stereotype.Controller
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.net.URI
import java.time.Duration


@Controller
class GraphQLController(builder: RSocketGraphQlClient.Builder<*>) {

    private val client: RSocketGraphQlClient =
        builder.webSocket(URI("ws://localhost:8080/rsocket")).build()

    @QueryMapping
    fun greeting(): String {
        return "Greeting, world!"
    }

    @QueryMapping
    fun callGreeting(): Mono<String> {
        return client.document("{ greeting }")
            .retrieve("greeting")
            .toEntity(String::class.java)
    }

    @QueryMapping
    fun callIntegers(): Flux<Int> {
        return client.document("subscription { integers }")
            .retrieveSubscription("integers")
            .toEntity(Int::class.java)
    }

    @SubscriptionMapping
    fun integers(): Flux<Int> = Flux.range(0, 100).delayElements(Duration.ofMillis(80))

}