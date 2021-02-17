package com.example.multiscree

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {


    val MSG = "com.example.multiScreen.msg"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun placeOrder(view:View)
    {
        //will handle intent
        var intent= Intent(this, OrderActivity::class.java)

        lateinit var editTxt1: EditText
        lateinit var editTxt2: EditText
        lateinit var editTxt3: EditText
        editTxt1= findViewById(R.id.item1)
        editTxt3= findViewById(R.id.item3)
        editTxt2= findViewById(R.id.item2)

        var item1:String? = editTxt1.text.toString()
        var item2:String? = editTxt2.text.toString()
        var item3:String? = editTxt3.text.toString()
        var message:String?= "$item1 , $item2 and $item3 are ordered."

        intent.putExtra("Message", message)
        startActivity(intent)


    }
}
