package com.example.uicomponentsa

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("UseSwitchCompatOrMaterialCode", "InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvGreeting = findViewById<TextView>(R.id.tv_greeting)
        var tvGreetingColor: Int = Color.RED

        val btnSubmit = findViewById<Button>(R.id.btn_submit)
        btnSubmit.setOnClickListener {

            //makeCustomToast()
//            Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show()
        }

        val rbGroupColor = findViewById<RadioGroup>(R.id.color_radioBtn_group)
        rbGroupColor.setOnClickListener {
            val radioBtnColor = rbGroupColor.checkedRadioButtonId
            tvGreetingColor = when(radioBtnColor) {
                R.id.red_rb -> Color.RED
                R.id.blue_rb -> Color.BLUE
                R.id.green_rb -> Color.GREEN
                else -> Color.BLACK
            }
        }

        val swNotification = findViewById<Switch>(R.id.sw_change_color)
        swNotification.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) {
               tvGreeting.setTextColor(tvGreetingColor)
            } else {
                tvGreeting.setTextColor(Color.BLACK)
            }
        }

    }

    fun makeCustomToast() {
        val inflater = layoutInflater
        val layout = inflater.inflate(R.layout.custom_toast_layout,null)

        val txt = layout.findViewById<TextView>(R.id.toastMsg)
        txt.text = "Custom Toast Clicked"

        val myToast = Toast(applicationContext)

        myToast.apply {
            setGravity(Gravity.CENTER,0,0)
            duration = Toast.LENGTH_LONG
            view = layout
            show()
        }
    }
}