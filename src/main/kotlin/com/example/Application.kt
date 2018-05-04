package com.example

import com.example.routers.Router
import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse


@MapperScan("com.example.mappers")
@SpringBootApplication
class Application {

    @Bean
    fun routes(routers: List<Router>): RouterFunction<ServerResponse> =
        routers.map { it.route().filter { req, next ->
            next.handle(req)
        } }.reduce { route1, route2 -> route1.and(route2) }
}

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}

