package com.example.demo3eotherimportantviews

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.demo3eotherimportantviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var count = 0

        binding.btnInc.setOnClickListener {
            count++
            binding.result.text = count.toString()
        }

        binding.btnDec.setOnClickListener {
            count--
            binding.result.text = count.toString()
        }

        binding.btnCollapsing.setOnClickListener {
            startActivity(Intent(this, CollapseAppBarActivity :: class.java))
        }
    }
}