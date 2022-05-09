package com.JJVCorporation.constraintlayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import java.lang.annotation.Native

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


       // val button = view.findViewById<Button>(R.id.BtnLoggin)
        val b : Button = findViewById(R.id.BtnLoggin)
        b.setOnClickListener{
            startActivity(Intent(this, Constraint2::class.java))
        }



    }
}