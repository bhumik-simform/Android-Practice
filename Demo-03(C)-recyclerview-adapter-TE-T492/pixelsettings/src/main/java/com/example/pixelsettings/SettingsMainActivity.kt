package com.example.pixelsettings

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SettingsMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_settings_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val settingRecyclerView = findViewById<RecyclerView>(R.id.rvSetting)
        settingRecyclerView.adapter = SettingsAdapter()
        settingRecyclerView.layoutManager = LinearLayoutManager(this)
        settingRecyclerView.addItemDecoration(SpacingSectioningDecoration())
        settingRecyclerView.addItemDecoration(DynamicCornerItemDecoration(this))
    }
}