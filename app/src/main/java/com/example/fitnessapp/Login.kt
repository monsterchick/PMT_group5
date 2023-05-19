package com.example.fitnessapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView


class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // page login to page signup
        val btnSignUp: Button = findViewById(R.id.btnSignUp)
        btnSignUp.setOnClickListener {
            val intent = Intent(this, Signup::class.java)
            startActivity(intent)
        }
        // page login to page forgot
        val btnToCreateAcc: Button = findViewById(R.id.btnToCreateAcc)
        btnToCreateAcc.setOnClickListener {
            val intent = Intent(this, Forgot::class.java)
            startActivity(intent)
        }

        // login logic
        val tvUsername: TextView = findViewById(R.id.tvUsername)
        val tvPassword: TextView = findViewById(R.id.tvPassword)
        val btnLogin:Button = findViewById(R.id.btnLogin)
        btnLogin.setOnClickListener {
            val username = tvUsername.text.toString()
            val password = tvPassword.text.toString()
            Log.d("aaa", username + password)


        }
    }
}