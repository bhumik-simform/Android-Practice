package com.example.demo4androidwebservices.views

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demo4androidwebservices.R
import com.example.demo4androidwebservices.data.models.TaskModel
import com.example.demo4androidwebservices.databinding.ActivityTodoHomeBinding
import com.example.demo4androidwebservices.viewModels.TaskViewModel
import com.example.demo4androidwebservices.viewModels.TodoHomeUiState

class TodoHomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTodoHomeBinding

    private lateinit var adapter: TaskListAdapter

    private val viewModel = TaskViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityTodoHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        viewModel.fetchTasks()
        setupObserver()
        setupRecyclerView()
    }

    private fun setupObserver() {
        viewModel.uiState.observe(this) {
            when(it) {
                is TodoHomeUiState.IsLoading -> {
                    binding.rvTodoList.visibility = View.GONE
                    binding.progressCircular.visibility = View.VISIBLE
                }
                is TodoHomeUiState.IsSuccess -> {
                    binding.progressCircular.visibility = View.GONE
                    binding.rvTodoList.visibility = View.VISIBLE

                    adapter.submitList(it.tasks)
                }
                is TodoHomeUiState.IsError -> {
                    binding.progressCircular.visibility = View.GONE
                    Log.e("ApiError",it.message)
                    Toast.makeText(this,it.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun setupRecyclerView() {

        val itemOnClick: (TaskModel)-> Unit = { item ->
            viewModel.toggleStatus(item)
        }

        adapter = TaskListAdapter(itemOnClick)
        binding.rvTodoList.adapter = adapter
        binding.rvTodoList.addItemDecoration(TaskListDecor(32))
        binding.rvTodoList.layoutManager = LinearLayoutManager(this)
    }

}