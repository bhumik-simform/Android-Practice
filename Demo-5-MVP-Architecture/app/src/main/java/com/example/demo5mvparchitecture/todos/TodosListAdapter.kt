package com.example.demo5mvparchitecture.todos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.demo5mvparchitecture.databinding.ItemTodoTaskBinding

class TodosListAdapter(
    private val onItemClicked: (TodoTask) -> Unit
) : ListAdapter<TodoTask, TodosListAdapter.TodosViewHolder>(TodosDiffCallBack()) {
    // Create New View Holders
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TodosViewHolder {
        val binding =
            ItemTodoTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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

    inner class TodosViewHolder(private val binding: ItemTodoTaskBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(item: TodoTask) { // Used to bind data of item with view widgets
            binding.tvTaskTitle.text = item.taskTitle
            binding.cbTaskCompletion.isChecked = item.isCompleted ?: false
            binding.root.setOnClickListener {
                onItemClicked(item)
            }
        }
    }

    //Implemented to compare items of recycler view to upgrade view efficiently
    class TodosDiffCallBack : DiffUtil.ItemCallback<TodoTask>() {
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