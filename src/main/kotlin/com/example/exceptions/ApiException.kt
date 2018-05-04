package com.example.exceptions

import org.springframework.http.HttpStatus

class ApiException : Exception {
    var statusCode = HttpStatus.INTERNAL_SERVER_ERROR

    var errorMessage =  HttpStatus.INTERNAL_SERVER_ERROR.toString()

    constructor(statusCode: HttpStatus): super() {
        this.statusCode = statusCode
        this.errorMessage = statusCode.toString()
    }

    constructor(statusCode: HttpStatus, message: String, throwable: Throwable): super(message, throwable) {
        this.statusCode = statusCode
        this.errorMessage = statusCode.toString()
    }

    constructor(statusCode: HttpStatus, throwable: Throwable): super(throwable) {
        this.statusCode = statusCode
        this.errorMessage = statusCode.toString()
    }

}

