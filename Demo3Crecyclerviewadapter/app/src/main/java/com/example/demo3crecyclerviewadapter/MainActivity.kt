package com.example.demo3crecyclerviewadapter

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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
            val intent = Intent(this, ListViewPracActivity::class.java)
            startActivity(intent)
        }

        val recyclerViewPracticeBtn = findViewById<Button>(R.id.btn_recycler_view_practice)
        recyclerViewPracticeBtn.setOnClickListener {
            val intent = Intent(this, RecyclerViewPracActivity::class.java)
            startActivity(intent)
        }
    }
}