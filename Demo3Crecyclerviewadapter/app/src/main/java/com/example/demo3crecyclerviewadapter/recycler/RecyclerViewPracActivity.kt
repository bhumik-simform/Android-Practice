package com.example.demo3crecyclerviewadapter.recycler

import android.app.Dialog
import android.os.Build
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demo3crecyclerviewadapter.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText

class RecyclerViewPracActivity : AppCompatActivity() {


    @RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
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
        val adapter = OsAdapter(osList) { clickedItem ->
            Toast.makeText(this, clickedItem.message, Toast.LENGTH_SHORT).show()
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
//      recyclerView.addItemDecoration(DividerDecoration())
        recyclerView.addItemDecoration(SpacingDecoration(32))


        val fabAddItem = findViewById<FloatingActionButton>(R.id.fab_add)
        fabAddItem.setOnClickListener {
            val dialog = Dialog(this)
            dialog.setContentView(R.layout.dialog_add_item)
            dialog.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            dialog.window?.setBackgroundDrawableResource(R.drawable.dialog_bg)

            val etName = dialog.findViewById<TextInputEditText>(R.id.edit_text_name)
            val etYear = dialog.findViewById<TextInputEditText>(R.id.edit_text_year)

            val addBtn = dialog.findViewById<Button>(R.id.btn_add)
            val cancelBtn = dialog.findViewById<Button>(R.id.btn_cancel)

            addBtn.setOnClickListener {
                val newOS = MyOS(
                    etName.text.toString(),
                    etYear.text.toString(),
                    R.drawable.ic_default,
                    "Hello"
                )
                osList.add(newOS)
                adapter.notifyDataSetChanged()
                dialog.dismiss()
            }
            cancelBtn.setOnClickListener {
                dialog.dismiss()
            }
            dialog.setCancelable(true)
            dialog.show()
        }

    }
}