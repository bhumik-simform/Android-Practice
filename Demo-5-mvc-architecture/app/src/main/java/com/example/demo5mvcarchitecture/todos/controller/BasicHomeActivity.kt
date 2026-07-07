package com.example.demo5mvcarchitecture.todos.controller

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demo5mvcarchitecture.R
import com.example.demo5mvcarchitecture.databinding.ActivityBasicHomeBinding
import com.example.demo5mvcarchitecture.todos.view.TodosItemDecor
import com.example.demo5mvcarchitecture.todos.view.TodosListAdapter

class BasicHomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBasicHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityBasicHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupUi()
    }


    // Functions which help to set up UI
    private fun setupUi() {
        setupTodosRecyclerView()
    }

    private fun setupTodosRecyclerView() {
        binding.rvTodos.apply {
            layoutManager = LinearLayoutManager(this@BasicHomeActivity)
            adapter = TodosListAdapter()
            addItemDecoration(TodosItemDecor(32))
        }
    }

    private fun fetchTasks() {

    }
}