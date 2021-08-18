package com.example.second

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.second.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private var mBinding: ActivityLoginBinding? = null

    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        signInPage()
    }

    private fun signInPage() {
        binding.signButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onDestroy() {
        mBinding = null
        super.onDestroy()
    }
}