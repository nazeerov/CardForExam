package com.nazirov.cardsforexam.model

import android.annotation.SuppressLint
import com.google.gson.annotations.SerializedName


@SuppressLint("ParcelCreator")
data class Card(
    @SerializedName("card_number")
    val cardNumber: String,
    @SerializedName("card_holder_name")
    val cardHolderName: String,
    @SerializedName("expires_date")
    val expiresDate: String,

    val id: Int? = null
)
//data class Card(
//    val name: String,
//    val card_number:String,
//    val cvv: String,
//    val date: String,
//    val id: String
//)


//
//"name": "name 1",
//"card_number": "card_number 1",
//"cvv": "cvv 1",
//"date": "date 1",
//"id": "1"