package com.example.notesappapi.models

/*
Data Class of userResponse has been created from postman collection value, we have token value
and user
 */

data class UserResponse(
    val Token: String,
    val user: User
)