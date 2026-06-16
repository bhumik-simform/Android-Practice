package com.example.demo4androidwebservices

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.demo4androidwebservices.databinding.ItemTodoTaskBinding

class TaskListAdapter : ListAdapter<TaskModel, TaskListAdapter.TaskViewHolder>(TaskDiffCallback()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TaskViewHolder {
        val binding =
            ItemTodoTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: TaskViewHolder,
        position: Int
    ) {
        val item = getItem(position)
        holder.bindData(item)
    }

    class TaskViewHolder(val binding: ItemTodoTaskBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(task: TaskModel) {
            binding.tvTaskTitle.text = task.title
            binding.cbTaskStatus.isChecked = task.completed
        }
    }

    class TaskDiffCallback : DiffUtil.ItemCallback<TaskModel>() {
        override fun areItemsTheSame(
            oldItem: TaskModel,
            newItem: TaskModel
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: TaskModel,
            newItem: TaskModel
        ) = oldItem == newItem

    }
}