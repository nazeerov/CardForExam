package com.nazirov.cardsforexam.activity

import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nazirov.cardsforexam.R
import com.nazirov.cardsforexam.adapter.CardAdapter
import com.nazirov.cardsforexam.model.Card
import com.nazirov.cardsforexam.networking.RetrofitHttp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var addButton:ImageView
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: CardAdapter
    var cards=ArrayList<Card>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        addButton = findViewById(R.id.ivAdd)
        addButton.setOnClickListener {
            val intent = Intent(this,AddCardActivity::class.java)
            startActivity(intent)
        }
        recyclerView=findViewById(R.id.recyclerView)
        adapter= CardAdapter(cards)
        recyclerView.adapter=adapter
        recyclerView.layoutManager= GridLayoutManager(this,1)

        if (isInternetAvailable()){
            getAllcards()
        } else{
            getAllcardsFromLocal()
        }

    }

    private fun getAllcardsFromLocal() {

    }

    private fun getAllcards() {
        RetrofitHttp.cardService.getAllCards().enqueue(object : Callback<ArrayList<Card>> {
            override fun onResponse(
                call: Call<ArrayList<Card>>,
                response: Response<ArrayList<Card>>
            ) {
                Log.d("responseim", response.body().toString())
                if (response.body()!=null){
                    cards.clear()
                    cards.addAll(response.body()!!)
                    adapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<ArrayList<Card>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Something went Wrong", Toast.LENGTH_SHORT).show()
            }

        })
    }


    private fun isInternetAvailable(): Boolean {
        val manager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val infoMobile = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
        val infoWifi = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
        return infoMobile!!.isConnected || infoWifi!!.isConnected
    }
}