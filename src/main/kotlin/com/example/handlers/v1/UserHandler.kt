package com.example.handlers.v1

import com.api.coinlog.extensions.serializeJson
import com.example.exceptions.ApiException
import com.example.mappers.UserMapper
import org.springframework.stereotype.Component

@Component
class UserHandler constructor(private val mapper: UserMapper) {

    @Throws(ApiException::class)
    fun index() = mapper.findAll().serializeJson()

}
