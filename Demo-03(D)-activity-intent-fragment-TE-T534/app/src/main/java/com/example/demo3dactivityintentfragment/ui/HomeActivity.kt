package com.example.demo3dactivityintentfragment.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demo3dactivityintentfragment.R
import com.example.demo3dactivityintentfragment.adapater.DishAdapter
import com.example.demo3dactivityintentfragment.data.allDishes
import com.example.demo3dactivityintentfragment.decor.DishItemDividerDecoration
import com.example.demo3dactivityintentfragment.model.Dish

class HomeActivity : AppCompatActivity() {
    lateinit var dishRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupRecyclerView()
    }

    fun setupRecyclerView() {

        val seDishItemClickListener: (Dish) -> Unit = { dish ->
            val intent = Intent(this, DishDetailActivity::class.java).apply {
                putExtra("Dish_Parcel", dish)
            }
            startActivity(intent)
        }

        dishRecyclerView = findViewById(R.id.recycler_view_dish)
        dishRecyclerView.layoutManager = LinearLayoutManager(this)
        dishRecyclerView.adapter = DishAdapter(allDishes, seDishItemClickListener)
//        dishRecyclerView.addItemDecoration(DishItemDividerDecoration())
    }
}