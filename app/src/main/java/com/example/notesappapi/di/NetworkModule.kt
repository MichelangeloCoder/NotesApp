package com.example.notesappapi.di

import com.example.notesappapi.api.AuthInterceptor
import com.example.notesappapi.api.NotesAPI
import com.example.notesappapi.api.UserAPI
import com.example.notesappapi.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    /*
    Here we have created first retrofit object and we have changed with retrofit.Builder
    and it will return as retrofit.Builder
     */
    @Singleton
    @Provides
    fun providesRetrofitBuilder(): Retrofit.Builder {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
    }

    /*
    Here in below code we have created OkHttpClient we have initialized AuthInterceptor
    and we have added addInterceptor inside AuthInterceptor return type will be OkHttpClient.
     */
    @Singleton
    @Provides
    fun provideOkHttpCilent(authInterceptor: AuthInterceptor) : OkHttpClient{
        return OkHttpClient.Builder().addInterceptor(authInterceptor).build()
    }

    /*
    here in below UserApi we have initialized retrofitBuilder we have build retrofitBuilder
    and we have passed UserAPI Interface
     */
    @Singleton
    @Provides
    fun providesUserAPI(retrofitBuilder: Retrofit.Builder) : UserAPI{
        return retrofitBuilder.build().create(UserAPI::class.java)
    }

/*
here we have access  retrofitBuilder and we access okHttpClient also here when we build first retrofitBuilder
okHttpClient will call first and called NotesAPI
 */
    @Singleton
    @Provides
    fun providesNoteAPI(retrofitBuilder: Retrofit.Builder, okHttpClient: OkHttpClient) : NotesAPI{
        return retrofitBuilder
            .client(okHttpClient)
            .build().create(NotesAPI::class.java)

    }
}