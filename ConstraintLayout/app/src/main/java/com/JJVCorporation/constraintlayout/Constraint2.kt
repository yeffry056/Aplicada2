package com.JJVCorporation.constraintlayout

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Constraint2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint2)

        val btn : Button = findViewById(R.id.siguiente)
        btn.setOnClickListener{
            startActivity(Intent(this, Constraint3::class.java))
        }
    }
}