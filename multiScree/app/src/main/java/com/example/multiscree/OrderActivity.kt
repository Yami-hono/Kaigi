package com.example.multiscree

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        //var bundle:Bundle? = intent.extras
        //var msg= bundle!!.getString("Message")
        //var intent= intent.extras
        var msg:String?= intent.getStringExtra("Message")

        var textView: TextView = findViewById(R.id.OrderText)
        textView.setText(msg)
        print(textView)

     }
}