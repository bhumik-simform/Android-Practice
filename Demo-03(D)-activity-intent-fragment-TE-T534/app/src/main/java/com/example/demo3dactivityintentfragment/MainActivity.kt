package com.example.demo3dactivityintentfragment

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var activityButton: Button
    private lateinit var dialogButton: Button

    private val tag = "LifeCycle"
     companion object {
         var activityCounter = 0
     }

    private var activityId = ++activityCounter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupButtons()
        Log.d(tag,"1-> onCreate()")
    }

    override fun onStart() {
        super.onStart()
        Log.d(tag,"1-> onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag,"1-> onResume()")
        println()
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag,"1-> onPause()")
        println()
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(tag,"1-> onRestart()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag,"1-> onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag,"1-> onDestroy()")
    }


    private fun setupButtons() {

        findViewById<Button>(R.id.btn_new_activity).setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java))
        }

        findViewById<Button>(R.id.btn_dialog)
            .setOnClickListener {
            val dialog = Dialog(this)
            dialog.setContentView(R.layout.dialog_hello)
            dialog.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            dialog.setCancelable(true)
            dialog.show()
        }
    }
}