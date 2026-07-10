package com.example.demo5mvvmarchitecture.auth.login.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.demo5mvvmarchitecture.R
import com.example.demo5mvvmarchitecture.auth.login.model.LoginResponse
import com.example.demo5mvvmarchitecture.auth.login.viewmodel.LoginViewModel
import com.example.demo5mvvmarchitecture.auth.options.LoginUiState
import com.example.demo5mvvmarchitecture.databinding.ActivityLoginBinding
import com.example.demo5mvvmarchitecture.todos.usertodos.view.UserTodosActivity
import kotlin.getValue

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }

        setupObservers()
        setupClickListeners()
    }

    // Observe all UI states emitted by ViewModel.
    private fun setupObservers() {
        viewModel.uiState.observe(this) { state ->
            when (state) {
                is LoginUiState.OnLoadingState -> {
                    showLoadingState(true)
                }

                is LoginUiState.OnSuccess -> {
                    showLoadingState(false)
                    navigateToUserTodos(state.data)
                }

                is LoginUiState.OnError -> {
                    showLoadingState(false)
                    Toast.makeText(
                        this,
                        state.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }

                is LoginUiState.UsernameError -> {
                    binding.etUsername.error = state.message
                    binding.etUsername.requestFocus()
                }

                is LoginUiState.PasswordError -> {
                    binding.etPassword.error = state.message
                    binding.etPassword.requestFocus()
                }
            }
        }
    }

    // Handle all click events.
    private fun setupClickListeners() {
        binding.etUsername.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_NEXT) {
                binding.etUsername.requestFocus()
                true
            } else {
                false
            }
        }
        binding.etPassword.setOnEditorActionListener { view, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                hideKeyboard(view)
                login()
                true
            } else {
                false
            }
        }
        binding.btnLogin.setOnClickListener {
            login()
        }
    }


    // Collect user input and pass it to ViewModel.
    private fun login() {
        // Clear previous errors
        binding.etUsername.error = null
        binding.etPassword.error = null
        val username = binding.etUsername.text.toString().trim()
        val password = binding.etPassword.text.toString()
        viewModel.login(username, password)
    }

    // Show/Hide loading state.
    private fun showLoadingState(isLoading: Boolean) {
        binding.apply {
            progressCircular.visibility =
                if (isLoading) View.VISIBLE else View.GONE
            btnLogin.isEnabled = !isLoading
            etUsername.isEnabled = !isLoading
            etPassword.isEnabled = !isLoading
        }
    }

    // Hide Soft Keyboard
    private fun hideKeyboard(view: View) {
        val inputMethodManager =
            getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager

        inputMethodManager.hideSoftInputFromWindow(
            view.windowToken,
            0
        )
    }

    private fun navigateToUserTodos(forUser: LoginResponse) {
        val intent = Intent(this, UserTodosActivity::class.java)
        intent.putExtra("LOGED_IN_USER", forUser)
        startActivity(intent)
    }
}