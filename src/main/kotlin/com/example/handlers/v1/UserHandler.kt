package com.example.handlers.v1

import com.api.coinlog.extensions.serializeJson
import com.example.exceptions.ApiException
import com.example.exceptions.UserRequest
import com.example.mappers.UserMapper
import com.example.models.User
import org.springframework.stereotype.Component
import org.springframework.validation.BeanPropertyBindingResult
import org.springframework.validation.Errors
import org.springframework.validation.ValidationUtils
import org.springframework.validation.Validator
import org.springframework.web.reactive.function.server.ServerRequest

@Component
class UserHandler constructor(private val mapper: UserMapper) {

    @Throws(ApiException::class)
    fun index() = mapper.findAll().serializeJson()

    @Throws(ApiException::class)
    fun store(req: ServerRequest): String {
        println("っっっっｈ{}")
        val user = req.bodyToMono(UserRequest::class.java).block()

        val validator = UserValidator()
        val errors = BeanPropertyBindingResult(user, User::class.java.name)
        validator.validate(user, errors)

        // has validate error
        if (errors != null) {
            println(errors.errorCount)
            println(errors.allErrors)
        }
        return mapper.findAll().serializeJson()
    }

}

class UserValidator: Validator {
    override fun supports(p0: Class<*>?): Boolean {
        return User::class.java.isAssignableFrom(p0)
    }

    override fun validate(obj: Any?, e: Errors?) {
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "id", "field.required", "IDは必須です")
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "name", "field.required", "名前は必須です")

    }

}
