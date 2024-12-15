package com.dicoding.mybookaplication

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val dataBook = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Book>("key_book", Book::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Book>("key_book")
        }
        val titleTextView: TextView = findViewById(R.id.judulDetail)
        val descriptionTextView: TextView = findViewById(R.id.descriptionDetail)
        val imageView: ImageView = findViewById(R.id.imageDetail)
        val priceTextView: TextView = findViewById(R.id.priceDetail)
        val authorTextView: TextView = findViewById(R.id.authorDetail)

        titleTextView.text = dataBook?.name
        descriptionTextView.text = dataBook?.description
        imageView.setImageResource(dataBook?.photo ?: R.id.imageDetail)
        priceTextView.text = dataBook?.price
        authorTextView.text = dataBook?.author

    }
}