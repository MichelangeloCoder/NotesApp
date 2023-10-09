package com.example.notesappapi.utils

import android.content.Context
import com.example.notesappapi.utils.Constants.PREFS_TOKEN_FILE
import com.example.notesappapi.utils.Constants.USER_TOKEN
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class TokenManger @Inject constructor(@ApplicationContext context : Context) {

    private var prefs = context.getSharedPreferences(PREFS_TOKEN_FILE, Context.MODE_PRIVATE)

    fun saveToken(token: String){
        val editor = prefs.edit()
        editor.putString(USER_TOKEN,token)
        editor.apply()
    }

    fun getToken() : String? {
        return prefs.getString(USER_TOKEN,null)
    }
}