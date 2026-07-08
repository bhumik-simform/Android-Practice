package com.example.demo5mvvmarchitecture.todos.usertodos.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demo5mvvmarchitecture.auth.login.model.LoginResponse
import com.example.demo5mvvmarchitecture.todos.options.UserTodosUiState
import com.example.demo5mvvmarchitecture.databinding.ActivityUserTodosBinding
import com.example.demo5mvvmarchitecture.todos.usertodos.model.TodoTask
import com.example.demo5mvvmarchitecture.todos.usertodos.viewmodel.UserTodosViewModel

class UserTodosActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserTodosBinding
    private val viewModel: UserTodosViewModel by viewModels()
    private lateinit var adapter: TodosListAdapter
    private val loggedInUser: LoginResponse? by lazy {
        intent.getParcelableExtra("LOGED_IN_USER", LoginResponse::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityUserTodosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupUi()
        setupObserver()
        fetchTodos()
    }
    private fun setupObserver() {
        viewModel.uiState.observe(this) { state ->
            when(state) {
                is UserTodosUiState.LoadingState -> {
                    showLoadingState(true)
                }
                is UserTodosUiState.OnError -> {
                    showLoadingState(false)
                    if(state.defaultList != null) adapter.submitList(state.defaultList)
                    Toast.makeText(this,state.message, Toast.LENGTH_SHORT).show()
                }
                is UserTodosUiState.OnSuccess -> {
                    showLoadingState(false)
                    adapter.submitList(state.data)
                }
            }
        }
    }
    private fun setupUi() {
        setupRecyclerView()
        setupToolbar()
    }
    private fun setupToolbar() {
        val userName = loggedInUser?.name ?: return
        binding.toolBarUserTodos.title = "Hello $userName"
    }
    private fun setupRecyclerView() {

        val onItemClicked: (TodoTask)-> Unit = { todoItem ->
            viewModel.toggleStatusFor(todoItem)
        }

        adapter = TodosListAdapter(onItemClicked)

        binding.rvTodos.apply {
            layoutManager = LinearLayoutManager(this@UserTodosActivity)
            adapter = this@UserTodosActivity.adapter
            addItemDecoration(TodosItemDecor(32))
        }
    }
    private fun fetchTodos() {
        val userId = loggedInUser?.userId ?: return
        viewModel.fetchTodosFor(userId)
    }
    private fun showLoadingState(isLoading: Boolean) {
        binding.rvTodos.isVisible = !isLoading
        binding.progressCircular.visibility = if(isLoading) View.VISIBLE else View.GONE
    }
}