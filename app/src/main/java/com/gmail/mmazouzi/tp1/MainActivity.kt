package com.gmail.mmazouzi.tp1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var imageView: ImageView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView = findViewById(R.id.image_view)
        button = findViewById(R.id.my_button)
        button.setOnClickListener(this)
        loadImage("https://www.rd.com/wp-content/uploads/2021/01/GettyImages-588935825.jpg")
    }
    fun loadImage(url: String) {
        Picasso.get()
            .load(url)
            // .resize(300, 300)
            // .centerCrop()
            .into(imageView)
    }

    override fun onClick(v: View?) {
        val links = listOf(
            "https://cdn.pixabay.com/photo/2017/09/25/13/12/cocker-spaniel-2785074__340.jpg",
            "https://www.jax.org/-/media/0586dfc4d83842cca60fde459c567617.jpg",
            "https://m.media-amazon.com/images/I/61lCLrCtuhL._AC_SL1000_.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/8/8f/Mouse_white_background.jpg",
        )
        loadImage(links.random())

        Toast.makeText(this, "You click me", Toast.LENGTH_LONG).show()
    }
}
