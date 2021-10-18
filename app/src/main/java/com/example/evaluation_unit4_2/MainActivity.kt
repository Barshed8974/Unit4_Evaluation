package com.example.evaluation_unit4_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), onClick {
    var mutableList= mutableListOf<Model>()
    lateinit var mAdapter: Adapter
    lateinit var mButton: Button
    lateinit var recyclerView: RecyclerView
    lateinit var dbHandler: DBHandler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dbHandler= DBHandler(this)
        mutableList=dbHandler.getDb()
        recyclerView=findViewById(R.id.recycler)


        dbHandler.insert("Function","Party","25th Decenber","Dubai","200$")
        dbHandler.insert("Function","Party","25th Decenber","Dubai","200$")
        dbHandler.insert("Function","Party","25th Decenber","Dubai","200$")
        dbHandler.insert("Function","Party","25th Decenber","Dubai","200$")

        mButton=findViewById(R.id.add)
        mButton.setOnClickListener(View.OnClickListener {
            dbHandler.insert("Function","Party","25th Decenber","Dubai","200$")
            mutableList.clear()
            mutableList.addAll(dbHandler.getDb())
            mAdapter.notifyDataSetChanged()
        })
        mAdapter= Adapter(this,mutableList,this)
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter=mAdapter
    }

    override fun edit(model: Model) {
        dbHandler.update(model.id,"WeekEnd","Dance",model.date,model.location,model.pricew)
        mutableList.clear()
        mutableList.addAll(dbHandler.getDb())
        mAdapter.notifyDataSetChanged()
    }

    override fun delete(model: Model) {
        dbHandler.delete(model.id)
        mutableList.clear()
        mutableList.addAll(dbHandler.getDb())
        mAdapter.notifyDataSetChanged()
    }
}