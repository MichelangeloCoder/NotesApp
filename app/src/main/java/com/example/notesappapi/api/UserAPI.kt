package com.example.notesappapi.api

import com.example.notesappapi.models.UserRequest
import com.example.notesappapi.models.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserAPI {


    /*
    we want to make user signup or register we have passed user information from UserRequest Model class
    and in response it will send UserResponse model class we are using Couroutuine used suspended
    signup is post method endpoint signup body is userRequest send
     */
    @POST("/users/signup")
    suspend fun signup(@Body UserRequest: UserRequest) : Response<UserResponse>

    /*
    we want to make user signin or Login we have passed user information from UserRequest Model class
    and in response it will send UserResponse model class we are using Couroutuine used suspended
    signin is post method endpoint signin body is userRequest send
     */
    @POST("/users/signin")
    suspend fun signin(@Body UserRequest: UserRequest) : Response<UserResponse>
}