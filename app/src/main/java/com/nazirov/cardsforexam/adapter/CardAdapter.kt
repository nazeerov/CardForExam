package com.nazirov.cardsforexam.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nazirov.cardsforexam.R
import com.nazirov.cardsforexam.model.Card

class CardAdapter(var list:ArrayList<Card>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CardViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_item,parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var item=list[position]
        if(holder is CardViewHolder){
            holder.apply {
                tv_card_number.text=item.cardNumber
                tv_expire_date.text=item.expiresDate
                tv_holder_name.text=item.cardHolderName
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class CardViewHolder(view: View): RecyclerView.ViewHolder(view){
        var tv_card_number=view.findViewById<TextView>(R.id.tv_card_number)
        var tv_holder_name=view.findViewById<TextView>(R.id.tv_card_holder)
        var tv_expire_date=view.findViewById<TextView>(R.id.tv_ex_date)
    }

}