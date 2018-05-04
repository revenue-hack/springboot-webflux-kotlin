package com.example.mappers

import com.example.exceptions.ApiException
import com.example.models.User
import org.springframework.stereotype.Repository

@Repository
interface UserMapper {
    @Throws(ApiException::class)
    fun findAll(): List<User>
}
