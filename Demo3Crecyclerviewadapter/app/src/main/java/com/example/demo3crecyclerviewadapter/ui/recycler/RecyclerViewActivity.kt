package com.example.demo3crecyclerviewadapter.ui.recycler

import android.app.Dialog
import android.os.Build
import android.os.Bundle
import android.view.ViewGroup
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demo3crecyclerviewadapter.R
import com.example.demo3crecyclerviewadapter.data.osDataList
import com.example.demo3crecyclerviewadapter.model.OSModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

@RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
class RecyclerViewActivity: AppCompatActivity() {

    enum class DialogMode {
        ADD,
        EDIT
    }
    private lateinit var adapter: OsAdapter

    @RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_os_recycler)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setUpRecycler()
        setUpFab()
    }

    private fun setUpRecycler() {
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        adapter = OsAdapter(osDataList) { item, position ->
            showOsDialog(
                mode = DialogMode.EDIT,
                existingItem = item,
                position = position
            )
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
//      recyclerView.addItemDecoration(DividerDecoration())
        recyclerView.addItemDecoration(SpacingDecoration(32))
    }

    private fun setUpFab() {
        val fabAddItem = findViewById<FloatingActionButton>(R.id.fab_add)
        fabAddItem.setOnClickListener {
            showOsDialog(mode = DialogMode.ADD)
        }
    }

    private fun addData(name:String, year: String) {
        osDataList.addFirst(
            OSModel(
                name = name,
                year = year,
                R.drawable.ic_os_default
            )
        )
        adapter.notifyItemInserted(0)
    }

    private fun updateData(name:String, year: String, position: Int) {
        val updatedItem = osDataList[position].copy(
            name = name,
            year = year
        )
        osDataList[position] = updatedItem
        adapter.notifyItemChanged(position)
    }



    private fun showOsDialog(
        mode: DialogMode,
        existingItem: OSModel? = null,
        position: Int? = null
    ) {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_os)
        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.window?.setBackgroundDrawableResource(R.drawable.bg_dialog)

        val titleText = dialog.findViewById<TextView>(R.id.dialog_title)
        val ipName = dialog.findViewById<TextInputLayout>(R.id.input_name)
        val ipYear = dialog.findViewById<TextInputLayout>(R.id.input_year)
        val etName = dialog.findViewById<TextInputEditText>(R.id.edit_text_name)
        val etYear = dialog.findViewById<TextInputEditText>(R.id.edit_text_year)
        val modifyBtn = dialog.findViewById<Button>(R.id.btn_modify)
        val cancelBtn = dialog.findViewById<Button>(R.id.btn_cancel)

        if (mode== DialogMode.ADD) {
            titleText.text = "Add Item"
            modifyBtn.text = "Add"
            ipName.hint = "Add Name"
            ipYear.hint = "Add Year"

        } else {
            titleText.text = "Edit Item"
            modifyBtn.text = "Edit"
            ipName.hint = "Edit Name"
            ipYear.hint = "Edit Year"
            etName.setText(existingItem?.name)
            etYear.setText(existingItem?.year)
        }

        modifyBtn.setOnClickListener {
            val name = etName.text.toString()
            val year = etYear.text.toString()
            if(mode== DialogMode.ADD) {
                addData(name,year)
            } else {
                updateData(name,year,position?:0)
            }
            dialog.dismiss()
        }

        cancelBtn.setOnClickListener {
            dialog.dismiss()
        }

        etName.requestFocus()
        dialog.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)

        dialog.setCancelable(true)
        dialog.show()
    }
}