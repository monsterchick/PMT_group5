package com.example.fitnessapp

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import org.json.JSONObject


class Login : AppCompatActivity() {
    val jsonObj = JSONObject()
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
        val btnToCreateAcc: Button = findViewById(R.id.btnToForgotPage)
        btnToCreateAcc.setOnClickListener {
            val intent = Intent(this, Forgot::class.java)
            startActivity(intent)
        }

        // save data to database
        val usnFromSignup = intent.getStringExtra("username")
        val pasFromSignup = intent.getStringExtra("password")

        Log.d("usere","userextra $usnFromSignup $pasFromSignup")


        // login logic
        val tvUsername: TextView = findViewById(R.id.tvUsername)
        val tvPassword: TextView = findViewById(R.id.tvPassword)
        val btnLogin:Button = findViewById(R.id.btnLogin)
        val tvPromtMsg:TextView = findViewById(R.id.tvPromtMsg)

        btnLogin.setOnClickListener {
            val username = tvUsername.text.toString()
            val password = tvPassword.text.toString()
            // login validation
            if (username!=usnFromSignup && password==pasFromSignup){
//                Log.d("case","username incor. password corr")
                tvPromtMsg.setTextColor(Color.RED)
                tvPromtMsg.text = "Username or Password was wrong retry"
            } else if(username==usnFromSignup && password!=pasFromSignup){
//                Log.d("case","username corr. password incorr")
                tvPromtMsg.setTextColor(Color.RED)
                tvPromtMsg.text = "Username or Password was wrong retry"
            } else if(username!=usnFromSignup && password!=pasFromSignup){
//                Log.d("case","username incorr. password incorr")
                tvPromtMsg.setTextColor(Color.RED)
                tvPromtMsg.text = "Username or Password was wrong retry"
            } else{
//                Log.d("case","username corr. password corr")
                tvPromtMsg.setTextColor(Color.GREEN)
                tvPromtMsg.text = "Successful login"

                val intent = Intent(this,Main::class.java)
                startActivity(intent)
            }
        }
    }
}