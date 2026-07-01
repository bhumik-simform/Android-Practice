package com.example.demo4androidwebservices.crud.views

import android.app.Dialog
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demo4androidwebservices.R
import com.example.demo4androidwebservices.crud.data.models.TaskModel
import com.example.demo4androidwebservices.databinding.ActivityTodoHomeBinding
import com.example.demo4androidwebservices.databinding.DialogAddTaskBinding
import com.example.demo4androidwebservices.databinding.DialogFilterTaskBinding
import com.example.demo4androidwebservices.crud.viewModels.TaskViewModel
import com.google.android.material.snackbar.Snackbar

class TodoHomeActivity: AppCompatActivity() {

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

        setupMenu()
        viewModel.fetchTasks()
        setupObserver()
        setupRecyclerView()
        setupOnclick()
    }


    private fun setupMenu() {

        this.setSupportActionBar(binding.toolBarTodoHome)

        val menuHost: MenuHost = this
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_todo_home, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.action_filter -> {
                        showFilterDialog()
                        true
                    }

                    else -> false
                }
            }
        })
    }

    private fun setupObserver() {

        viewModel.loadingState.observe(this) { isLoading ->

            binding.progressCircular.visibility =
                if (isLoading) View.VISIBLE
                else View.GONE

            binding.rvTodoList.visibility =
                if (isLoading) View.GONE
                else View.VISIBLE

            binding.fabAddItem.isEnabled = !isLoading
        }

        viewModel.tasks.observe(this) {
            adapter.submitList(it)
        }

        viewModel.onError.observe(this) { errorMessage ->
            if (errorMessage.isNotEmpty()) {
                Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupRecyclerView() {

        val itemOnClick: (TaskModel) -> Unit = { item ->
            viewModel.toggleStatus(item)
        }

        val itemSwipe: (Int) -> Unit = { position ->

            val deletingTask = adapter.currentList.elementAt(position)

            viewModel.deleteTask(deletingTask)

            Snackbar.make(binding.rvTodoList, "Delete mistakenly!!", Snackbar.LENGTH_SHORT)
                .setAction("Undo it") {
                    viewModel.undoDeleteTask(position, deletingTask)
                }
                .show()
        }
        adapter = TaskListAdapter(itemOnClick)

        binding.rvTodoList.adapter = adapter
        binding.rvTodoList.addItemDecoration(TaskListDecor(40))
        binding.rvTodoList.layoutManager = LinearLayoutManager(this)
        SwipeToDeleteCallback.addGesture(binding.rvTodoList, itemSwipe)
    }

    private fun setupOnclick() {
        binding.fabAddItem.setOnClickListener {
            showAddTaskDialog()
        }
    }

    private fun showAddTaskDialog() {

        val bindingDialog = DialogAddTaskBinding.inflate(layoutInflater)

        val dialog = Dialog(this)
        dialog.setContentView(bindingDialog.root)

        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        dialog.window?.setBackgroundDrawableResource(R.drawable.bg_dialog)

        val userId: String by lazy {
            bindingDialog.editTextId.text.toString()
        }

        val taskTitle: String by lazy {
            bindingDialog.editTextTitle.text.toString()
        }

        bindingDialog.editTextId.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_NEXT) {
                if (userId.isEmpty()) {
                    bindingDialog.editTextId.error = "Enter User Id"
                } else {
                    if (userId.toInt() in 1..<11) {
                        userId.toDouble()
                        bindingDialog.editTextId.error = null
                        bindingDialog.editTextTitle.requestFocus()
                    } else {
                        bindingDialog.editTextId.error = "Add appropriate id"
                    }
                }
                true
            } else {
                false
            }
        }

        bindingDialog.editTextTitle.setOnEditorActionListener { view, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                if (taskTitle.isEmpty()) {
                    bindingDialog.editTextTitle.error = "Add task title"
                } else {
                    bindingDialog.editTextTitle.error = null

                    val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(view.windowToken, 0)
                }
                true
            } else {
                false
            }
        }

        bindingDialog.btnCancel.setOnClickListener {
            dialog.dismiss()
        }

        bindingDialog.btnAdd.setOnClickListener {

            if (userId.isEmpty()) {
                bindingDialog.editTextId.error = "Enter User Id"
                bindingDialog.editTextId.requestFocus()
            } else {
                if (userId.toInt() in 1..<11) {
                    bindingDialog.editTextId.error = null
                } else {
                    bindingDialog.editTextId.error = "Add appropriate id"
                }
            }

            if (taskTitle.isEmpty()) {
                bindingDialog.editTextTitle.error = "Add task title"
                bindingDialog.editTextId.requestFocus()
            } else {
                bindingDialog.editTextTitle.error = null
            }

            dialog.dismiss()
            viewModel.addTask(userId.toInt(), taskTitle)
        }


        bindingDialog.editTextId.requestFocus()

        dialog.setCancelable(false)
        dialog.show()
    }


    private fun showFilterDialog() {

        val dialogBinding = DialogFilterTaskBinding.inflate(layoutInflater)

        val dialog = Dialog(this)
        dialog.setContentView(dialogBinding.root)

        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        dialog.window?.setBackgroundDrawableResource(R.drawable.bg_dialog)

        var userId: Int? = null
        var completed: Boolean? = null

        val userIds = Array(11) { if (it == 0) "All Users" else it.toString() }
        val idAdapter =
            ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, userIds)

        dialogBinding.autoComTvUserId.apply {
            setAdapter(idAdapter)
            setText(this.adapter.getItem(0).toString(), false)
            setOnItemClickListener { parent, _, position, _ ->
               userId = parent.getItemAtPosition(position).toString().toIntOrNull()
            }
        }

        dialogBinding.radioGrpStatus.setOnCheckedChangeListener { _, checkedStatus ->
            completed = when(checkedStatus) {
                R.id.radio_btn_both -> null
                R.id.radio_btn_com -> true
                R.id.radio_btn_inCom -> false
                else -> null
            }
        }

        dialogBinding.btnCancel.setOnClickListener {
            dialog.dismiss()
        }

        dialogBinding.btnApplyFilter.setOnClickListener {
            dialog.dismiss()
            viewModel.applyFilters(userId, completed)
        }

        dialog.setCancelable(false)
        dialog.show()
    }
}


/*
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
*/