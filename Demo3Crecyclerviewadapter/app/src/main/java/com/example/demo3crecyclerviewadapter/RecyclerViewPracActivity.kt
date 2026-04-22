package com.example.demo3crecyclerviewadapter

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewPracActivity : AppCompatActivity() {

    data class OS (
        val name: String,
        val year: String,
        val imgId: Int,
        val message: String
    )
    val osList = listOf(
        OS("Android", "2008", R.drawable.ic_android,"Made by Google"),
        OS("iOS", "2007", R.drawable.ic_ios,"Made by Apple"),
        OS("Ubuntu", "2004", R.drawable.ic_ubuntu, "Made by Canonical"),
        OS("Windows", "1985", R.drawable.ic_windows, "Made by Microsoft"),
        OS("macOS", "2001", R.drawable.ic_macos,"Made by Apple"),
        OS("BlackBerry OS", "1999", R.drawable.ic_blackberry,"Made by Black Berry"),
        OS("Linux", "1991", R.drawable.ic_linux, "Made by OG........."),
        OS("Chrome OS", "2011", R.drawable.ic_chrome_os,"Made by Google"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler_view_prac)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyAdapter(osList)
    }

    class MyAdapter(val list: List<OS>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
        inner class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
            val osImageView: ImageView
            val osNameTextView: TextView
            val yearTextView: TextView

            init {
                osImageView = view.findViewById(R.id.iv_os_icon)
                osNameTextView = view.findViewById(R.id.tv_os_name)
                yearTextView = view.findViewById(R.id.tv_year)
                view.setOnClickListener {
                    val position = bindingAdapterPosition
                    Log.i("Click Happen","${list[position]}")
                }
            }




        }

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): MyViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
            return MyViewHolder(view)
        }

        override fun onBindViewHolder(
            holder: MyViewHolder,
            position: Int
        ) {
            holder.osImageView.setImageResource(list[position].imgId)
            holder.osNameTextView.text = list[position].name
            holder.yearTextView.text = list[position].year
        }

        override fun getItemCount() = list.size

    }
}