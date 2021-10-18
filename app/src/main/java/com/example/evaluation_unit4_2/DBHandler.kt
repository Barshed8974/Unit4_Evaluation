package com.example.evaluation_unit4_2

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class DBHandler (val context: Context): SQLiteOpenHelper(context,"MyDb",null,1) {

    companion object{
        val TABLENAME="MyDb"
        val ID="Id"
        val TITTLE="Title"
        val DESC="Desc"
        val DATE="Date"
        val LOC="Location"
        val PRICE="Price"
    }

    override fun onCreate(p0: SQLiteDatabase?) {

        val Create="CREATE TABLE $TABLENAME($ID INTEGER PRIMARY KEY, $TITTLE TEXT," +
                "$DESC TEXT,$DATE TEXT,$LOC TEXT,$PRICE TEXT)"
        p0?.execSQL(Create)
    }

    fun insert(tittle:String, desc:String, date:String, location:String, price:String)
    {
        val db=writableDatabase
        val data=ContentValues()
        data.put(TITTLE,tittle)
        data.put(DESC,desc)
        data.put(DATE,date)
        data.put(LOC,location)
        data.put(PRICE,price)

        val id:Long=db.insert(TABLENAME,null,data)
        if(id.toInt()==-1)
            Toast.makeText(context,"Failed",Toast.LENGTH_LONG).show()
        else
            Toast.makeText(context,"Success",Toast.LENGTH_LONG).show()

    }

    fun delete(id:Int)
    {
        val db=writableDatabase
        val deletedRow:Int=db.delete(TABLENAME,"Id=$id",null)
        if(deletedRow.toInt()==-1)
            Toast.makeText(context,"Failed",Toast.LENGTH_LONG).show()
        else
            Toast.makeText(context,"Success",Toast.LENGTH_LONG).show()
    }

    fun update(id:Int,tittle:String,desc:String,date:String,location:String,price:String)
    {
        val db=writableDatabase
        val data=ContentValues()
        data.put(TITTLE,tittle)
        data.put(DESC,desc)
        data.put(DATE,date)
        data.put(LOC,location)
        data.put(PRICE,price)

        val id:Int=db.update(TABLENAME,data,"Id=$id",null)
        if(id.toInt()==-1)
            Toast.makeText(context,"Failed",Toast.LENGTH_LONG).show()
        else
            Toast.makeText(context,"Success",Toast.LENGTH_LONG).show()

    }

    fun getDb():MutableList<Model>
    {
        val list:MutableList<Model> = mutableListOf<Model>()
        val db=readableDatabase
        val query="Select * from $TABLENAME"
        val cursor=db.rawQuery(query,null)

        val idIndex=cursor.getColumnIndex(ID)
        val tittleIndex=cursor.getColumnIndex(TITTLE)
        val descIndex=cursor.getColumnIndex(DESC)
        val dateIndex=cursor.getColumnIndex(DATE)
        val locationIndex=cursor.getColumnIndex(LOC)
        val priceIndex=cursor.getColumnIndex(PRICE)

        if(cursor!=null&&cursor.count>0)
        {
            cursor.moveToFirst()
            do {
                var id=cursor.getInt(idIndex)
                var tittle=cursor.getString(tittleIndex)
                var desc=cursor.getString(descIndex)
                var date=cursor.getString(dateIndex)
                var location=cursor.getString(locationIndex)
                var price=cursor.getString(priceIndex)

                var model=Model(id,tittle,desc,date,location,price)

                list.add(model)
            }
                while (cursor.moveToNext())
        }
        return list
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}