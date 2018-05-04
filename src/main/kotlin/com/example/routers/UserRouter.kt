package com.example.routers

import com.example.handlers.v1.UserHandler
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import org.springframework.web.reactive.function.server.router
import reactor.core.publisher.toMono

@Component
class UserRouter(private val handler: UserHandler) : Router {
    override fun route() = router {
        ("/user").nest {
            GET("") { req ->
                ServerResponse.ok()
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .body(handler.index().toMono())
            }
        }
    }.filter { request, next ->
        print("fileter")
        next.handle(request)
    }
}
