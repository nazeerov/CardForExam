package com.nazirov.cardsforexam.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cards")
data class CardDB (

    @PrimaryKey
    val id : String,

    val name: String,
    val card_number:String,
    val cvv:String,
    val date:String



//"name": "name 1",
//"card_number": "card_number 1",
//"cvv": "cvv 1",
//"date": "date 1",
//"id": "1"

)