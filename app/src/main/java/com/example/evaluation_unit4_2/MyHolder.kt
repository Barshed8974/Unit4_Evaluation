package com.example.evaluation_unit4_2

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyHolder(itemView :View): RecyclerView.ViewHolder(itemView) {
    var idTv:TextView
    var tittleTv:TextView
    var descTv:TextView
    var dateTv:TextView
    var locationTv:TextView
    var priceTv:TextView
    var edit:Button
    var delete:Button
    init {
        idTv=itemView.findViewById(R.id.id)
        descTv=itemView.findViewById(R.id.desc)
        tittleTv=itemView.findViewById(R.id.tittle)
        dateTv=itemView.findViewById(R.id.date)
        locationTv=itemView.findViewById(R.id.location)
        priceTv=itemView.findViewById(R.id.price)
        idTv=itemView.findViewById(R.id.id)
        edit=itemView.findViewById(R.id.edit)
        delete=itemView.findViewById(R.id.delete)
    }
    fun setData(model: Model)
    {
        idTv.setText(model.id.toString())
        tittleTv.setText(model.tittle)
        descTv.setText(model.tittle)
        dateTv.setText(model.date)
        locationTv.setText(model.location)
        priceTv.setText(model.pricew)
    }
}