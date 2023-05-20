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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // page login to page signup
        val btnSignUp: Button = findViewById(R.id.btnSignUp)
        btnSignUp.setOnClickListener {
            val intent = Intent(this, Signup::class.java)
            startActivity(intent)
        }
        val data = intent.getStringExtra("user")
        Log.d("data","$data")

        // page login to page forgot
        val btnToCreateAcc: Button = findViewById(R.id.btnToForgotPage)
        btnToCreateAcc.setOnClickListener {
            val intent = Intent(this, Forgot::class.java)
            startActivity(intent)
        }



        // login logic
        val tvUsername: TextView = findViewById(R.id.tvUsername)
        val tvPassword: TextView = findViewById(R.id.tvPassword)
        val btnLogin:Button = findViewById(R.id.btnLogin)
        val tvPromtMsg:TextView = findViewById(R.id.tvPromtMsg)

        btnLogin.setOnClickListener {
            val username = tvUsername.text.toString()
            val password = tvPassword.text.toString()

            val user = JSONObject()
            user.put("username","admin")
            user.put("password","123")

            // user database for testing
            val users = JSONObject()
            users.put("user_demo", user)

            val pwd = users.getJSONObject("user_demo").getString("password")
            val usr = users.getJSONObject("user_demo").getString("username")

            if (username!=usr && password==pwd){
//                Log.d("case","username incor. password corr")
                tvPromtMsg.setTextColor(Color.RED)
                tvPromtMsg.text = "Username or Password was wrong retry"
            } else if(username==usr && password!=pwd){
//                Log.d("case","username corr. password incorr")
                tvPromtMsg.setTextColor(Color.RED)
                tvPromtMsg.text = "Username or Password was wrong retry"
            } else if(username!=usr && password!=pwd){
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


            // test
            Log.d("test", "username:$username password:$password")
            val obj = users.toString()
            val specific_user = users.getJSONObject("user_demo").toString()
            val pwdtest = users.getJSONObject("user_demo").getString("password")
            Log.d("specific_user","specific_user:$specific_user")
            Log.d("pwd","password: $pwdtest")
            Log.d("testlogin","username:$username usr:$usr password:$password pwd:$pwd")

        }
    }
}