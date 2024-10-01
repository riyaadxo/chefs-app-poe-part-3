package com.example.chefsapp

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class AddMenuItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_menu_item)

        val dishNameInput = findViewById<EditText>(R.id.dishNameInput)
        val dishDescriptionInput = findViewById<EditText>(R.id.dishDescriptionInput)
        val dishPriceInput = findViewById<EditText>(R.id.dishPriceInput)
        val courseSpinner = findViewById<Spinner>(R.id.courseSpinner)
        val saveButton = findViewById<Button>(R.id.saveButton)

        // Predefined list of courses
        val courses = arrayOf("Starters", "Mains", "Dessert")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, courses)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        courseSpinner.adapter = adapter

        saveButton.setOnClickListener {
            val dishName = dishNameInput.text.toString()
            val dishDescription = dishDescriptionInput.text.toString()
            val dishPrice = dishPriceInput.text.toString().toDoubleOrNull() ?: 0.0
            val course = courseSpinner.selectedItem.toString()


            val resultIntent = Intent()


        }
    }
}

