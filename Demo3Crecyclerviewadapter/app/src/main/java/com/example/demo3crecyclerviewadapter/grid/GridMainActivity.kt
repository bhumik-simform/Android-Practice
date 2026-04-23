package com.example.demo3crecyclerviewadapter.grid

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demo3crecyclerviewadapter.R
import com.example.demo3crecyclerviewadapter.recycler.osList

class GridMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_grid_view_prac)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val gridView = findViewById<RecyclerView>(R.id.grid_view)
        gridView.layoutManager = GridLayoutManager(this, 2)
        gridView.adapter = GridOsAdapter(osList) { clickedItem ->
            Toast.makeText(this, clickedItem.message, Toast.LENGTH_SHORT).show()
        }
    }
}