package com.example.demo5mvparchitecture.todos

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demo5mvparchitecture.databinding.ActivityUserTodosBinding
import com.example.demo5mvparchitecture.auth.LoginResponse
import kotlin.getValue
class UserTodosActivity : AppCompatActivity(), UserTodosView{
    private lateinit var binding: ActivityUserTodosBinding
    private val presenter: UserTodosPresenter by lazy {
        UserTodosPresenter(this)
    }
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
        fetchTodos()
    }
    private fun setupUi() {
        setupRecyclerView()
        setupToolbar()
    }
    private fun setupToolbar() {
        val userName = loggedInUser?.userName ?: return
        binding.toolBarUserTodos.title = "Hello $userName"
    }
    private fun setupRecyclerView() {
        val onItemClicked: (TodoTask)-> Unit = { todoItem ->
            presenter.toggleStatusFor(todoItem)
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
        presenter.fetchTodosFor(userId)
    }
    private fun showLoadingState(isLoading: Boolean) {
        binding.rvTodos.isVisible = !isLoading
        binding.progressCircular.visibility = if(isLoading) View.VISIBLE else View.GONE
    }

    override fun startLoadingState() {
        showLoadingState(true)
    }

    override fun stopLoadingState() {
        showLoadingState(false)
    }

    override fun onError(message: String, defaultData: List<TodoTask>?) {
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
        if (defaultData != null) {
            adapter.submitList(defaultData)
        }
    }

    override fun onSuccess(data: List<TodoTask>) {
        adapter.submitList(data)
    }
}