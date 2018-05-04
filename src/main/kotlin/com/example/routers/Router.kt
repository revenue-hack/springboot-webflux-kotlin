package com.example.routers

import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse

interface Router {
    fun route(): RouterFunction<ServerResponse>
}