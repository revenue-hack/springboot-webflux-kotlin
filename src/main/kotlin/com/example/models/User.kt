package com.example.models

import java.sql.Timestamp

data class User(
    val id: Int,
    val name: String,
    val createdAt: Timestamp?,
    val isDelete: Int
)
