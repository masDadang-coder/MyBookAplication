package com.dicoding.mybookaplication

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvBooks: RecyclerView
    private val list = ArrayList<Book>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvBooks = findViewById(R.id.rv_books)
        rvBooks.setHasFixedSize(true)

        list.addAll(getListBooks())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.about -> {
                val intent = Intent(this, About::class.java)
                startActivity(intent)
                true
            }
            else-> super.onOptionsItemSelected(item)
        }
    }

    private fun getListBooks(): ArrayList<Book> {
        val dataName = resources.getStringArray(R.array.data_judul)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataPrice = resources.getStringArray(R.array.data_price)
        val dataAuthor = resources.getStringArray(R.array.data_author)
        val listBook = ArrayList<Book>()
        for (i in dataName.indices) {
            val hero = Book(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1), dataPrice[i], dataAuthor[i])
            listBook.add(hero)
        }
        return listBook
    }

    private fun showRecyclerList() {
        rvBooks.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListBookAdapter(list)
        rvBooks.adapter = listHeroAdapter
    }
}