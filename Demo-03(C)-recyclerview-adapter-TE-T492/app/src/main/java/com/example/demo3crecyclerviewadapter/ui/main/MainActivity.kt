package com.example.demo3crecyclerviewadapter.ui.main

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.demo3crecyclerviewadapter.R
import com.example.demo3crecyclerviewadapter.ui.recycler.RecyclerViewActivity
import com.example.demo3crecyclerviewadapter.ui.grid.OsGridActivity
import com.example.demo3crecyclerviewadapter.ui.listview.OsListActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val listViewPracticeBtn = findViewById<Button>(R.id.btn_list_view_practice)
        listViewPracticeBtn.setOnClickListener {
            val intent = Intent(this, OsListActivity::class.java)
            startActivity(intent)
        }

        val recyclerViewPracticeBtn = findViewById<Button>(R.id.btn_recycler_view_practice)
        recyclerViewPracticeBtn.setOnClickListener {
            val intent = Intent(this, RecyclerViewActivity::class.java)
            startActivity(intent)
        }

        val gridViewPracticeBtn = findViewById<Button>(R.id.btn_grid_view_practice)
       gridViewPracticeBtn.setOnClickListener {
            val intent = Intent(this, OsGridActivity::class.java)
            startActivity(intent)
        }
    }
}