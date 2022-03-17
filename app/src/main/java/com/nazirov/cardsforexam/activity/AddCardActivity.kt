package com.nazirov.cardsforexam.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.nazirov.cardsforexam.R
import com.nazirov.cardsforexam.helper.Logger
import com.nazirov.cardsforexam.model.Card
import com.nazirov.cardsforexam.networking.RetrofitHttp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddCardActivity : AppCompatActivity() {
    private val tag = AddCardActivity::class.simpleName

    private lateinit var etCardNumber: EditText
    private lateinit var etExDateMonth: EditText
    private lateinit var etExDateYear: EditText
    private lateinit var etCvv: EditText
    private lateinit var etCardHolderName: EditText
    private lateinit var btnAddCard: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_card)
        initViews()
    }

    private fun initViews() {
        etCardNumber = findViewById(R.id.etCardNumber)
        etExDateMonth = findViewById(R.id.etExDateMonth)
        etExDateYear = findViewById(R.id.etExDateYear)
        etCvv = findViewById(R.id.etCvv)
        etCardHolderName = findViewById(R.id.etCardHolderName)
        btnAddCard = findViewById(R.id.btnAddCard)
        val ivCancel: ImageView = findViewById(R.id.ivCancel)
        ivCancel.setOnClickListener {
            finish()
        }

        btnAddCard.setOnClickListener {
            val cardNumber = etCardNumber.text.toString()
            val cardHolderName = etCardHolderName.text.toString()
            val expiresDate = etExDateMonth.text.toString() + "/" + etExDateYear.text.toString()

            val card = Card(cardNumber, cardHolderName, expiresDate)
            sendData(card)
        }
    }

    private fun sendData(card: Card) {
        saveDataOnServer(card)
        Intent(this@AddCardActivity, MainActivity::class.java).also {
            startActivity(it)
            finish()
        }
    }

    private fun saveDataOnServer(card: Card) {
        RetrofitHttp.cardService.createCard(card).enqueue(object : Callback<Card> {
            override fun onResponse(call: Call<Card>, response: Response<Card>) {
                if (!response.isSuccessful) {
                    Logger.d(tag!!, "Error Code: ${response.code()}")
                    return
                }

                Logger.d(tag!!, "Card created: ${response.toString()}")
            }

            override fun onFailure(call: Call<Card>, t: Throwable) {
                Logger.e(tag!!, "Error: ${t.message}")
            }
        })
    }
}