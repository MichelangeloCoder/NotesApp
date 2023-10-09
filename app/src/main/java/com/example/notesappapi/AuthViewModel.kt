package com.example.notesappapi

import android.text.TextUtils
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesappapi.models.UserRequest
import com.example.notesappapi.models.UserResponse
import com.example.notesappapi.reposistory.UserReposistory
import com.example.notesappapi.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val userReposistory: UserReposistory) : ViewModel() {

    val userResponseLiveData : LiveData<NetworkResult<UserResponse>>
    get() = userReposistory.userResponseLiveData


    fun registerUser(userRequest: UserRequest){
        viewModelScope.launch {
            userReposistory.registerUser(userRequest)
        }

    }

    fun loginUser(userRequest: UserRequest){
        viewModelScope.launch {
            userReposistory.loginUser(userRequest)
        }
    }

    //function validateCredentials code it username, email, password we have used textUtils pattern method

    fun validateCredentials(username : String, emailAddress: String, password: String, isLogin: Boolean) : Pair<Boolean, String>{
        var result = Pair(true, "")
         if(!isLogin && TextUtils.isEmpty(username) || TextUtils.isEmpty(emailAddress) || TextUtils.isEmpty(password)){
             result = Pair(false, "Please provide the credentials")
         }
        else if(!Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches()){
            result = Pair(false, "Please provide valid email")
         }
        else if (password.length <=5){
            result = Pair(false, "Password length is to short")
         }
        return result

    }
}