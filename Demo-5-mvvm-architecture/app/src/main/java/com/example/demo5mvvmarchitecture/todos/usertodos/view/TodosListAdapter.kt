package com.example.demo5mvvmarchitecture.todos.usertodos.view

import com.example.demo5mvvmarchitecture.databinding.ItemTodoTaskBinding
import com.example.demo5mvvmarchitecture.todos.usertodos.model.TodoTask
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class TodosListAdapter: ListAdapter<TodoTask, TodosListAdapter.TodosViewHolder>(TodosDiffCallBack()) {
    // Create New View Holders
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TodosViewHolder {
        val binding = ItemTodoTaskBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TodosViewHolder(binding)
    }
    // Get item from list and bind it using View Holder
    override fun onBindViewHolder(
        holder: TodosViewHolder,
        position: Int
    ) {
        val item = getItem(position)
        holder.bindData(item)
    }
    class TodosViewHolder(private val binding: ItemTodoTaskBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindData(item: TodoTask) { // Used to bind data of item with view widgets
            binding.tvTaskTitle.text = item.taskTitle
            binding.cbTaskCompletion.isChecked = item.isCompleted ?: false
        }
    }
    //Implemented to compare items of recycler view to upgrade view efficiently
    class TodosDiffCallBack: DiffUtil.ItemCallback<TodoTask>() {
        override fun areItemsTheSame(
            oldItem: TodoTask,
            newItem: TodoTask
        ) = oldItem.taskId == newItem.taskId

        override fun areContentsTheSame(
            oldItem: TodoTask,
            newItem: TodoTask
        ) = oldItem == newItem
    }
}