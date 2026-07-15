package com.example.demo5mvparchitecture.auth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.demo5mvparchitecture.R
import com.example.demo5mvparchitecture.databinding.ActivityMainBinding
import com.example.demo5mvparchitecture.todos.UserTodosActivity

class MainActivity : AppCompatActivity(), LoginView {
    private lateinit var binding: ActivityMainBinding
    private val presenter: LoginPresenter by lazy {
        LoginPresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
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

        setupClickListeners()
    }

    // Observe all UI states emitted by ViewModel.
    override fun showLoadingState() {
        showLoading(true)
    }

    override fun hideLoadingState() {
        showLoading(false)
    }

    override fun showError(message: String) {
        Log.e("MyApiError",message)
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
    }

    override fun navigateToTodos(userId: LoginResponse) {
        navigateToUserTodos(userId)
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
        presenter.login(username, password)
    }

    // Show/Hide loading state.
    private fun showLoading(isLoading: Boolean) {
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