package com.nazirov.cardsforexam.networking

import com.nazirov.cardsforexam.networking.service.CardService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitHttp {
    companion object{
        private val TAG:String = RetrofitHttp::class.java.simpleName.toString()

        const val IS_TESTER: Boolean = true

        const val SERVER_DEVOLOPMENT = "https://6232aeb88364d63035c18a9a.mockapi.io/api/"
        const val SERVER_PRODUCTION = "https://6232aeb88364d63035c18a9a.mockapi.io/api/"

        private fun server():String{
            return if (IS_TESTER){
                SERVER_DEVOLOPMENT
            }else{
                SERVER_PRODUCTION
            }
        }

        private fun getRetrofit(): Retrofit {

            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(server())
                .build()
        }

        val userService:CardService = getRetrofit().create(CardService::class.java)
    }
}