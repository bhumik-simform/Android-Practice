package com.example.demo5androidpermissions

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.demo5androidpermissions.databinding.ActivityMainBinding
import com.example.demo5androidpermissions.views.CameraActivity
import com.example.demo5androidpermissions.views.GalleryActivity
import com.example.demo5androidpermissions.views.LocationActivity
import com.example.demo5androidpermissions.views.NotificationActivity
import com.example.demo5androidpermissions.views.PermissionsActivity
import com.example.demo5androidpermissions.views.StorageActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.apply {
            btnCamera.setOnClickListener { navigateToActivity(CameraActivity::class.java) }
            btnGallery.setOnClickListener { navigateToActivity(GalleryActivity::class.java) }
            btnLocation.setOnClickListener { navigateToActivity(LocationActivity::class.java) }
            btnNotification.setOnClickListener { navigateToActivity(NotificationActivity::class.java) }
            btnManageStorage.setOnClickListener { navigateToActivity(StorageActivity::class.java) }
            btnShowPermissions.setOnClickListener { navigateToActivity(PermissionsActivity::class.java) }
        }
    }

    private fun navigateToActivity(cls: Class<*>) {
        startActivity(Intent(this, cls))
    }
}
