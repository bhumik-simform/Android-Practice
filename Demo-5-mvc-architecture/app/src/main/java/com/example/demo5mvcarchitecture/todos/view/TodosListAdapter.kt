package com.example.demo5mvcarchitecture.todos.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.demo5mvcarchitecture.databinding.ItemTodoTaskBinding
import com.example.demo5mvcarchitecture.todos.model.UserTask

class TodosListAdapter: ListAdapter<UserTask, TodosListAdapter.TodosViewHolder>(TodosDiffCallBack()) {
    // Create New View Holders
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TodosViewHolder {
        val binding = ItemTodoTaskBinding.inflate(LayoutInflater.from(parent.context),parent,true)
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
        fun bindData(item: UserTask) { // Used to bind data of item with view widgets
            binding.tvTaskTitle.text = item.taskTitle
            item.isCompleted?.let {
                binding.cbTaskCompletion.isChecked = it
            }
        }
    }
    //Implemented to compare items of recycler view to upgrade view efficiently
    class TodosDiffCallBack: DiffUtil.ItemCallback<UserTask>() {
        override fun areItemsTheSame(
            oldItem: UserTask,
            newItem: UserTask
        ) = oldItem.taskId == newItem.taskId

        override fun areContentsTheSame(
            oldItem: UserTask,
            newItem: UserTask
        ) = oldItem == newItem
    }
}