package com.example.demo3crecyclerviewadapter.recycler



import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.demo3crecyclerviewadapter.R


class OsAdapter(private val list: List<MyOS>, private val onItemClick: (MyOS) -> Unit) :
    RecyclerView.Adapter<OsAdapter.OsViewHolder>() {
    inner class OsViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        private val osImageView: ImageView = view.findViewById(R.id.iv_os_icon)
        private val osNameTextView: TextView = view.findViewById(R.id.tv_os_name)
        private
        val yearTextView: TextView = view.findViewById(R.id.tv_year)

        @SuppressLint("SetTextI18n")
        fun bindData(item: MyOS) {
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
    ): OsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
        return OsViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: OsViewHolder,
        position: Int
    ) {
        val currOs = list[position]
        holder.bindData(currOs)
    }

    override fun getItemCount() = list.size

}