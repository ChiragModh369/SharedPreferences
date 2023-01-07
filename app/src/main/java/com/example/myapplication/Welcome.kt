package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class Welcome : AppCompatActivity() {

    lateinit var txtDisplay:TextView
    lateinit var btnLogout:Button
    lateinit var sharedPreferences:SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        txtDisplay = findViewById(R.id.txtDisplay)
        btnLogout = findViewById(R.id.btnLogout)

        sharedPreferences = this.getSharedPreferences("com.example.myapplication",Context.MODE_PRIVATE)
        var uname = sharedPreferences.getString("username",null)

//        txtDisplay.setText(uname)

        if (uname == null){

            var  intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        else
        {
            Toast.makeText(this,"Name is available",Toast.LENGTH_LONG).show()
            txtDisplay.setText(uname)
        }
    }

    override fun onStart() {
        super.onStart()

        btnLogout.setOnClickListener {
            var edit:SharedPreferences.Editor = sharedPreferences.edit()
            edit.clear()
            edit.commit()

            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Logout Successfull", Toast.LENGTH_SHORT).show()
        }
    }
}