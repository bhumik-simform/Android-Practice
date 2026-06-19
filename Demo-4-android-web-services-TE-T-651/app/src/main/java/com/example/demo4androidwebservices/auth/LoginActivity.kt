package com.example.demo4androidwebservices.auth

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.demo4androidwebservices.R
import com.example.demo4androidwebservices.databinding.ActivityLoginBinding

//import com.example.demo4androidwebservices.databinding.Acti

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupOnClicks()
        setupObserver()
    }


    private fun setupOnClicks() {

        binding.btnLogin.setOnClickListener {

            val userName = binding.editTextEmail.text.toString()
            val password = binding.editTextPassword.text.toString()

            viewModel.login(userName, password)
        }
    }

    private fun setupObserver() {
        viewModel.uiState.observe(this) {
            when (it) {
                is LoginUiState.OnLoadingState -> {
                    setLoadingUi(true)
                }

                is LoginUiState.OnSuccess -> {
                    setLoadingUi(false)
                    val intent = Intent(this, UserDetailActivity::class.java)
                    intent.putExtra("USER_DETAILS",it.data)
                    startActivity(intent)
                }

                is LoginUiState.OnError -> {
                    setLoadingUi(false)
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun setLoadingUi(isLoading: Boolean) {
        binding.btnLogin.isEnabled = !isLoading
        binding.editTextEmail.isEnabled = !isLoading
        binding.editTextPassword.isEnabled = !isLoading
        binding.progressCircular.visibility =
            if (isLoading) View.VISIBLE
            else View.GONE
    }
}