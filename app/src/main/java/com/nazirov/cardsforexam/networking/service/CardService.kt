package com.nazirov.cardsforexam.networking.service

import com.nazirov.cardsforexam.model.Card
import retrofit2.Call
import retrofit2.http.*

interface CardService {

    @GET("users")
    fun getAllUsers(): Call<ArrayList<Card>>

    @GET("users/{id}")
    fun getUser(@Path("id") id: Int): Call<Card>

    @POST("users")
    fun createUser(@Body card: Card): Call<Card>

    @PUT("users/{id}")
    fun updateUser(@Path("id") id: Int , @Body card: Card): Call<Card>

    @DELETE("users/{id}")
    fun deleteUser(@Path("id") id: Int) : Call<Card>
}