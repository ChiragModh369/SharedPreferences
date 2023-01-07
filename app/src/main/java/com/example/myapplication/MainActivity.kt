package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var txtlogin:TextView
    lateinit var edtUsername:EditText
    lateinit var edtPassword:EditText
    lateinit var btnLogin:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtlogin = findViewById(R.id.txtlogin)
        edtUsername = findViewById(R.id.edtUsername)
        edtPassword = findViewById(R.id.edtPassword)
        btnLogin = findViewById(R.id.btnLogin)
    }

    override fun onStart() {
        super.onStart()

        btnLogin.setOnClickListener {
            if(edtUsername.text.toString()=="abc" && edtPassword.text.toString()=="xyz"){
                //creating Shared Preferences
                var sharedPreferences = this.getSharedPreferences("com.example.myapplication",Context.MODE_PRIVATE)

                var editSharedPreferences = sharedPreferences.edit()

                editSharedPreferences.putString("username","abc")
                editSharedPreferences.apply()

                var intent = Intent(this,Welcome::class.java)
                startActivity(intent)

                Toast.makeText(this, "Login Successsfull", Toast.LENGTH_SHORT).show()

            }
        }
    }
}