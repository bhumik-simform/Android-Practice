package com.example.demo5mvcarchitecture.todos.controller

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demo5mvcarchitecture.R
import com.example.demo5mvcarchitecture.databinding.ActivityBasicHomeBinding
import com.example.demo5mvcarchitecture.todos.model.TodosModel
import com.example.demo5mvcarchitecture.todos.view.TodosItemDecor
import com.example.demo5mvcarchitecture.todos.view.TodosListAdapter
import kotlinx.coroutines.launch

class BasicHomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBasicHomeBinding
    private val adapter by lazy {
        TodosListAdapter()
    }

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
        fetchTasks()
    }
    // Functions which help to set up UI
    private fun setupUi() {
        setupTodosRecyclerView()
    }
    private fun setupTodosRecyclerView() {
        binding.rvTodos.apply {
            layoutManager = LinearLayoutManager(this@BasicHomeActivity)
            adapter = this@BasicHomeActivity.adapter
            addItemDecoration(TodosItemDecor(32))
        }
    }
    private fun fetchTasks() {
        lifecycleScope.launch {
            try {
                val userTasks = TodosModel.fetchTask()
                adapter.submitList(userTasks)
            } catch (e: Exception) {
                Toast.makeText(
                    this@BasicHomeActivity,
                    e.localizedMessage,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}