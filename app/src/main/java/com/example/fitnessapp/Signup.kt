package com.example.fitnessapp


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import android.content.Context
import android.graphics.Color

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
        val tvPromptMsg: TextView = findViewById(R.id.tvPromptMsg)
        btnCreateAcc.setOnClickListener {
            val email = tvEmail.text.toString()
            val username = tvUsername.text.toString()
            val password = tvPassword.text.toString()
            val confirmPsw = tvConfirmPassword.text.toString()
            // send data to login activity
            val intent = Intent(this, Login::class.java)
            intent.putExtra("username",username)
            intent.putExtra("password",password)
//            startActivity(intent)

            // email filter
            fun isEmailValid(email: String): Boolean {
                val emailRegex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\$")
                return email.matches(emailRegex)
            }
            fun isPasswordTheSame(pas1: String,pas2: String): Boolean {
                return pas1==pas2
            }
            isPasswordTheSame(password,confirmPsw)
            // case1: email format is invalid | both password not match
            if(!isEmailValid(email) && (!isPasswordTheSame(password,confirmPsw))){
                Log.d("get","False False")
                tvPromptMsg.setText("email format is invalid and both passwords do not match. Try again!")
                tvPromptMsg.setTextColor(Color.RED)
            // case2: email format is invalid | both password match
            } else if(!isEmailValid(email) && (isPasswordTheSame(password,confirmPsw))) {
                Log.d("get", "False True")
                tvPromptMsg.setText("email format is invalid. Try again!")
                tvPromptMsg.setTextColor(Color.RED)
            // case3: email format is valid | both password not match
            }else if(isEmailValid(email) && (!isPasswordTheSame(password,confirmPsw))){
                Log.d("get","True False")
                tvPromptMsg.setText("both passwords do not match. Try again!")
                tvPromptMsg.setTextColor(Color.RED)
            }else{
                Log.d("get", "True True")
                tvPromptMsg.setText("Sign up successful!")
                tvPromptMsg.setTextColor(Color.GREEN)

                // alert sign up successfully
                fun showAlertDialog(context: Context) {
                    val builder = AlertDialog.Builder(context)
                    builder.setTitle("Message")
                    builder.setMessage("Account created. Back to log in")
                    builder.setPositiveButton("OK"){ dialog, which ->
                        // back to login page
                        context.startActivity(intent)
                    }
                    builder.show()
                }
                showAlertDialog(this)
            }


            // for testing
//            Log.d("test_json_data","$user datatype: ${user::class.simpleName}")  // datatype: jsonObject
//            Log.d("test_signup","$fullname\n$username\n$email\n$password\n$confirmPsw")
//            val lenOfFullname = fullname.length
//            Log.d("len","$lenOfFullname")

        }
    }
}