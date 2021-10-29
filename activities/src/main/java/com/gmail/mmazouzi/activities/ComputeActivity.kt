package com.gmail.mmazouzi.activities
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
class ComputeActivity : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var text: TextView
    private lateinit var edittext1: EditText
    private lateinit var edittext2: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.compute_activity)
        button = findViewById(R.id.btn_calculer)
        text = findViewById(R.id.resultat)
        edittext1 = findViewById(R.id.field_1)
        edittext2 = findViewById(R.id.field_2)
        button.isEnabled = false
        edittext2.setOnClickListener {
            button.isEnabled = true
        }
        button.setOnClickListener {
            text.text = (edittext1.text.toString().toDouble() + edittext2.text.toString().toDouble()).toString()
        }
    }
}
