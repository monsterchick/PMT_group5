package com.example.fitnessapp


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import android.content.Context

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
            if(isEmailValid(email) && (isPasswordTheSame(password,confirmPsw))){
                Log.d("get","email valid? yes ${isPasswordTheSame(password, confirmPsw)}")
            } else{
                Log.d("get","email valid? no ${isPasswordTheSame(password, confirmPsw)}")
            }
            // alert sign up successfully
            fun showAlertDialog(context: Context) {
                val builder = AlertDialog.Builder(context)
                builder.setTitle("Message")
                builder.setMessage("Sign up Successful. Back to log in")
                builder.setPositiveButton("OK"){ dialog, which ->
                    // back to login page
                    context.startActivity(intent)
                }
                builder.show()
            }
            showAlertDialog(this)

            // for testing
//            Log.d("test_json_data","$user datatype: ${user::class.simpleName}")  // datatype: jsonObject
//            Log.d("test_signup","$fullname\n$username\n$email\n$password\n$confirmPsw")
//            val lenOfFullname = fullname.length
//            Log.d("len","$lenOfFullname")

        }
    }
}