package com.nazirov.cardsforexam.networking.service

import com.nazirov.cardsforexam.model.Card
import retrofit2.Call
import retrofit2.http.*

interface CardService {

    @GET("api")
    fun getAllCards(): Call<ArrayList<Card>>

    @GET("api/{id}")
    fun getCard(@Path("id") id: String): Call<Card>

    @POST("api")
    fun createCard(@Body card: Card): Call<Card>

}