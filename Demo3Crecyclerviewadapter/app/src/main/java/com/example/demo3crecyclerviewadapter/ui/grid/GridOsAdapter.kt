package com.example.demo3crecyclerviewadapter.ui.grid

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.demo3crecyclerviewadapter.R
import com.example.demo3crecyclerviewadapter.model.OSModel

class GridOsAdapter(private val list: List<OSModel>, private val onItemClick: (OSModel) -> Unit) :
    RecyclerView.Adapter<GridOsAdapter.GridOsViewHolder>() {
    inner class GridOsViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        private val osImageView: ImageView = view.findViewById(R.id.iv_os_icon)
        private val osNameTextView: TextView = view.findViewById(R.id.tv_os_name)
        private
        val yearTextView: TextView = view.findViewById(R.id.tv_year)

        @SuppressLint("SetTextI18n")
        fun bindData(item: OSModel) {
            osImageView.setImageResource(item.imgId)
            osNameTextView.text = item.name
            yearTextView.text = "Founded: ${item.year}"
            view.setOnClickListener {
                onItemClick(item)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GridOsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_os_grid, parent, false)
        return GridOsViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: GridOsViewHolder,
        position: Int
    ) {
        val currOs = list[position]
        holder.bindData(currOs)
    }

    override fun getItemCount() = list.size

}