package com.api.coinlog.extensions

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

fun Any.serializeJson(): String = jacksonObjectMapper().writeValueAsString(this)
