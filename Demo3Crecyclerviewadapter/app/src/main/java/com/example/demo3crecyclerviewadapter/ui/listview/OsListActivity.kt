package com.example.demo3crecyclerviewadapter.ui.listview

import android.os.Build
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.demo3crecyclerviewadapter.R

class OsListActivity : AppCompatActivity() {

    val tutorials: MutableList<String>  = mutableListOf( "Kotlin", "Swift", "Java", "Python", "C++", "C#", "JavaScript", "TypeScript", "Go", "Rust", "PHP", "Dart", "Ruby", "SQL")

    lateinit var languageList: ListView
    lateinit var inputTextField: EditText
    lateinit var addBtn: Button



    @RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_os_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        languageList = findViewById(R.id.list)

        val adapter: ArrayAdapter<String> = ArrayAdapter(
            this,
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
            tutorials
        )
        languageList.setAdapter(adapter)


        inputTextField = findViewById(R.id.edit_text_input)

        addBtn = findViewById(R.id.btn_add)
        addBtn.setOnClickListener {
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            val newLanguage = inputTextField.text.toString()
            if (!newLanguage.isEmpty()) {
                tutorials.addFirst(newLanguage)
                adapter.notifyDataSetChanged()
                inputTextField.text.clear()
                imm.hideSoftInputFromWindow(it.windowToken,0)
            } else {
                Toast.makeText(this, "Please Enter Any Language", Toast.LENGTH_SHORT).show()
            }
        }

        languageList.setOnItemLongClickListener { _, _ , position, _ ->
            tutorials.removeAt(position)
            adapter.notifyDataSetChanged()
            true
        }
    }
}