package com.nazirov.cardsforexam.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.nazirov.cardsforexam.R

class MainActivity : AppCompatActivity() {
    lateinit var ivAdd: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initviews()
    }

    private fun initviews() {
        ivAdd = findViewById(R.id.ivAdd)
        ivAdd.setOnClickListener{
            val intent  =Intent(this,AddCardActivity::class.java)
            startActivity(intent)
        }

    }
}