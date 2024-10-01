package com.example.chefsapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuAdapter

class MainActivity<MenuItem> : AppCompatActivity() {

    private val menuItems = mutableListOf<MenuItem>()
    @SuppressLint("RestrictedApi")
    private lateinit var menuAdapter: MenuAdapter
    private lateinit var menuItemsCount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addMenuItemBtn = findViewById<Button>(R.id.addMenuItemBtn)
        val menuListView = findViewById<ListView>(R.id.menuListView)
        menuItemsCount = findViewById(R.id.menuItemsCount)


        menuListView.adapter = menuAdapter

        addMenuItemBtn.setOnClickListener {
            val intent = Intent(this, AddMenuItemActivity::class.java)
            startActivityForResult(intent, 1)
        }
    }

    private fun MenuAdapter(mainActivity: MainActivity<MenuItem>, menuItems: MutableList<MenuItem>) {

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK) {
            val newItem = data?.getSerializableExtra("newItem") as MenuItem
            menuItems.add(newItem)
            updateMenuCount()
        }
    }

    private fun updateMenuCount() {
        menuItemsCount.text = "Total Menu Items: ${menuItems.size}"
    }
}
