package com.example.pixelsettings

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SettingsAdapter: RecyclerView.Adapter<SettingsAdapter.SettingsViewHolder>() {

    class SettingsViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val iconImageView: ImageView = view.findViewById(R.id.ivIcon)
        private val titleTextView: TextView = view.findViewById(R.id.tvTitle)
        private val subtitleTextView: TextView = view.findViewById(R.id.tvSubtitle)

        fun bindData(settingItem: SettingModel) {
            iconImageView.setImageResource(settingItem.iconId)
            titleTextView.text = settingItem.title
            subtitleTextView.text = settingItem.subTitle
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SettingsViewHolder {
        val newView = LayoutInflater.from(parent.context).inflate(R.layout.item_setting,parent,false)
        return SettingsViewHolder(newView)
    }

    override fun onBindViewHolder(
        holder: SettingsViewHolder,
        position: Int
    ) {
        val currentSettingItem = settingList.elementAt(position)
        holder.bindData(currentSettingItem)
    }

    override fun getItemCount() = settingList.count()
}

