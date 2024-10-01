package com.example.chefsapp

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView



class MenuAdapter(private val context: Context, private val dataSource: List<MenuItem>) : BaseAdapter() {

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("SetTextI18n")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // Inflate the layout if the convertView is null
        val rowView = convertView ?: LayoutInflater.from(context).inflate(R.layout.menu_item_row, parent, false)

        // Get references to the TextViews
        val nameTextView = rowView.findViewById<TextView>(R.id.dishNameText)
        val descriptionTextView = rowView.findViewById<TextView>(R.id.dishDescriptionText)
        val courseTextView = rowView.findViewById<TextView>(R.id.dishCourseText)
        val priceTextView = rowView.findViewById<TextView>(R.id.dishPriceText)

        // Get the current MenuItem
        val menuItem = getItem(position) as MenuItem

        // Set the TextViews with the MenuItem data
        nameTextView.text = menuItem.name
        descriptionTextView.text = menuItem.description
        courseTextView.text = menuItem.course
        priceTextView.text = "Price: $${menuItem.price}"

        return rowView
    }
}
