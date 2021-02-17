package com.example.kaigi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        lateinit var auth: FirebaseAuth
        auth=Firebase.auth

        var emailbox=findViewById<EditText?>(R.id.emailbox)
        var passwordbox=findViewById<EditText?>(R.id.passwordBox)
        var createbtn=findViewById<Button>(R.id.createBtn)
        var loginbtn=findViewById<Button>(R.id.loginbtn)


        loginbtn.setOnClickListener{

            var email = emailbox.text.toString()
            var password = passwordbox.text.toString()

            if(email.length>0 && password.length>0)
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this)
            { task ->
                if (task.isSuccessful) {
                    //do your stuff
                    Toast.makeText(baseContext, "Logged in", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, Dashboard::class.java))
                    finish()

                } else {
                    Toast.makeText(baseContext, "Login Failed", Toast.LENGTH_SHORT).show()
                }
            }
            else
            {
                Toast.makeText(baseContext,"Ye kya mazaak h, kuch toh Enter kr", Toast.LENGTH_SHORT).show()
            }
        }

        createbtn.setOnClickListener {
            val intent= Intent(this, SignupActivity::class.java)
            startActivity(intent)
            finish()
        }

        


    }
    fun forget(view:View){

        Toast.makeText(this, "You should've remembered, not my fault😑😑", Toast.LENGTH_SHORT).show()
    }

}