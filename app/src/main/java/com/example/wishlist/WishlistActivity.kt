package com.example.wishlist;
import WishlistAdapter
import WishlistItem
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wishlist.R



class WishlistActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: WishlistAdapter
    private val wishlistItems = mutableListOf<WishlistItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wishlist)

        recyclerView = findViewById(R.id.wishlistRecyclerView)
        adapter = WishlistAdapter(wishlistItems)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val editItemName: EditText = findViewById(R.id.editItemName)
        val editItemPrice: EditText = findViewById(R.id.editItemPrice)
        val editItemUrl: EditText = findViewById(R.id.editItemUrl)

        val addItemButton: Button = findViewById(R.id.addItemButton)
        addItemButton.setOnClickListener {
            // Get user input
            val itemName = editItemName.text.toString()
            val itemPriceText = editItemPrice.text.toString()
            val itemUrl = editItemUrl.text.toString()

            val itemPrice = itemPriceText.toDoubleOrNull() ?: 0.0

            val newItem = WishlistItem(itemName, itemPrice, itemUrl)

            wishlistItems.add(newItem)
            adapter.notifyDataSetChanged()

            editItemName.text.clear()
            editItemPrice.text.clear()
            editItemUrl.text.clear()
        }
    }
}
