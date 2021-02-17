package com.example.kaigi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class SignupActivity : AppCompatActivity() {

    val db =Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        var auth: FirebaseAuth = FirebaseAuth.getInstance()


        var namebox=findViewById<EditText?>(R.id.editTextTextPersonName)
        var emailbox=findViewById<EditText?>(R.id.emailbox)
        var passwordbox=findViewById<EditText?>(R.id.passwordBox)
        var createbtn=findViewById<Button>(R.id.createBtn)
        var loginbtn=findViewById<Button>(R.id.loginbtn)

        createbtn.setOnClickListener(View.OnClickListener() {
            var email = emailbox.text.toString()
            var password = passwordbox.text.toString()
            var name = namebox.text.toString()


            var user:User= User()
            user.email=email
            user.name=name
            user.password=password
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information

                            db.collection("Users").document().set(user).addOnSuccessListener(
                                OnSuccessListener {
                                    val intent= Intent(this, LoginActivity::class.java)
                                    startActivity(intent)
                                    finish()

                                }
                            )
                        Toast.makeText(baseContext, "Account Created Successfully",
                            Toast.LENGTH_SHORT).show()


                    } else {
                        // If sign in fails, display a message to the user.

                        Toast.makeText(baseContext, "Account Creation failed.",
                            Toast.LENGTH_SHORT).show()

                    }
                }
        })








        loginbtn.setOnClickListener{
            val intent= Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}