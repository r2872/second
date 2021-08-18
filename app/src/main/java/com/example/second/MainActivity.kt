package com.example.second

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.second.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mBinding: ActivityMainBinding? = null

    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        signButton()
        logInPage()
    }

    private fun signButton() {
        binding.signButton.setOnClickListener {
            if (!binding.checkbox.isChecked) {
                Toast.makeText(this, "이용약관에 먼저 동의 해 주세요", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
        }
    }

    private fun logInPage() {
        binding.loginButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onDestroy() {
        mBinding = null
        super.onDestroy()
    }
}