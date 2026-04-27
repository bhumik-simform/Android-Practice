package com.example.demo3crecyclerviewadapter.ui.grid

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demo3crecyclerviewadapter.R
import com.example.demo3crecyclerviewadapter.data.osDataList

class OsGridActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_os_grid)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val gridView = findViewById<RecyclerView>(R.id.grid_view)
        gridView.layoutManager = GridLayoutManager(this, 2)
        gridView.addItemDecoration(GridOsSpacingDecoration())
        gridView.adapter = GridOsAdapter(osDataList) { clickedItem ->
            Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show()
        }
    }
}