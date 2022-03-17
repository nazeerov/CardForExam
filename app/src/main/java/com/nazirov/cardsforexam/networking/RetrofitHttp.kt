package com.nazirov.cardsforexam.networking

import com.nazirov.cardsforexam.networking.service.CardService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitHttp {
    companion object {
        const val TAG = "RetrofitHttpCard"
        const val IS_TESTER = true

        const val SERVER_DEVELOPMENT = "https://6232aeb88364d63035c18a9a.mockapi.io/"
        const val SERVER_PRODUCTION = "https://6232aeb88364d63035c18a9a.mockapi.io/"

        private fun server(): String {
            if (IS_TESTER) {
                return SERVER_DEVELOPMENT
            }
            return SERVER_PRODUCTION
        }

        private fun getRetrofit(): Retrofit {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(server())
                .build()
        }

        val cardService= getRetrofit().create(CardService::class.java)
    }
}