package com.example.demo5mvcarchitecture.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.demo5mvcarchitecture.todos.controller.BasicHomeActivity
import com.example.demo5mvcarchitecture.R
import com.example.demo5mvcarchitecture.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding // Late init binding for binding Kotlin code with XML


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) // Inflated content view via binding
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupOnClicks()
    }

    private fun setupOnClicks() {
        // Setting on click invent for navigate to basic example Activity
        binding.btnBasicExp.setOnClickListener {
            val intent = Intent(this, BasicHomeActivity::class.java)
            startActivity(intent)
        }
        // Setting on click invent for navigate to moderate example Activity
        binding.btnModerateExp.setOnClickListener {

        }

    }
}