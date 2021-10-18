package com.example.evaluation_unit4_2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter(val context: Context,val mutableList: MutableList<Model>,
                val onClick: onClick): RecyclerView.Adapter<MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val inflater=LayoutInflater.from(context)
        val view=inflater.inflate(R.layout.item1,parent,false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var model = mutableList.get(position)
        holder.setData(model)
        holder.edit.setOnClickListener(View.OnClickListener {
            onClick.edit(model)
        })
        holder.delete.setOnClickListener(View.OnClickListener {
            onClick.delete(model)
        })
    }

    override fun getItemCount(): Int {
        return mutableList.size
    }
}