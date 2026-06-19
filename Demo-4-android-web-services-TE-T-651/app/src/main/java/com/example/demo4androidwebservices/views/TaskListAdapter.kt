package com.example.demo4androidwebservices.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.demo4androidwebservices.R
import com.example.demo4androidwebservices.data.models.TaskModel
import com.example.demo4androidwebservices.databinding.ItemTodoTaskBinding

class TaskListAdapter(
    private val onItemClicked: (TaskModel)-> Unit
) : ListAdapter<TaskModel, TaskListAdapter.TaskViewHolder>(TaskDiffCallback()) {

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

    inner class TaskViewHolder(val binding: ItemTodoTaskBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(task: TaskModel) {

            binding.tvTaskTitle.text = task.title
            binding.tvTaskUserId.apply {
                text = this.context.getString(R.string.item_task_tv_user_id, task.userId)
            }
            binding.cbTaskStatus.isChecked = task.completed

            binding.root.setOnClickListener {
                onItemClicked(task)
            }
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