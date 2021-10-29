package com.gmail.mmazouzi.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
class MainActivity : AppCompatActivity() {
    private lateinit var clickButton1: Button
    private lateinit var clickButton2: Button
    private lateinit var Click_me: TextView
    private var nbClick = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Click_me = findViewById(R.id.Click_me)
        clickButton1 = findViewById(R.id.btn_click_me)
        clickButton2 = findViewById(R.id.btn_compute)
        clickButton1.setOnClickListener {
            nbClick++
            val newText = "Vous avez cliquer $nbClick fois"
            Click_me.text = newText
            if (nbClick > 5) {
                clickButton1.isEnabled = false
            }
        }
        clickButton2.setOnClickListener {
            val intent = Intent(baseContext, ComputeActivity::class.java)
            startActivity(intent)
        }
    }
}

