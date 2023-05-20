package com.example.fitnessapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import org.json.JSONObject

class Signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val tvFullname: TextView = findViewById(R.id.tvFullName)
        val tvUsername: TextView = findViewById(R.id.tvUsername)
        val tvEmail: TextView = findViewById(R.id.tvEmail)
        val tvPassword: TextView = findViewById(R.id.tvPassword)
        val tvConfirmPassword: TextView = findViewById(R.id.tvConfirmPassword)
        val btnCreateAcc: TextView = findViewById(R.id.btnCreateAcc)
//        val tvPromptMsgE: TextView = findViewById(R.id.tvPromptMsgE)

        btnCreateAcc.setOnClickListener {
            val fullname = tvFullname.text.toString()
            val username = tvUsername.text.toString()
            val email = tvEmail.text.toString()
            val password = tvPassword.text.toString()
            val confirmPsw = tvConfirmPassword.text.toString()

            val user = JSONObject()
            // json string
            val users = JSONObject()
            user.put("fullname",fullname)
            user.put("email",email)
            user.put("username",username)
            user.put("password",password)
            users.put(fullname,user)

            val intent = Intent(this, Login::class.java)
            intent.putExtra("user",users.toString())

            // for testing
            Log.d("test_json_data","$users datatype: ${users::class.simpleName}")  // datatype: jsonObject
            Log.d("test_signup","$fullname\n$username\n$email\n$password\n$confirmPsw")
//            val lenOfFullname = fullname.length
//            Log.d("len","$lenOfFullname")

        }
    }
}