package com.example.notesappapi.models

/*
Data Class of userRequest has been created from postman collection value
 */

data class UserRequest(
    val email: String,
    val password: String,
    val username: String
)