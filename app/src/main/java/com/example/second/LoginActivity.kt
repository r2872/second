package com.example.second

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.second.databinding.ActivityLoginBinding
import java.util.regex.Pattern

class LoginActivity : AppCompatActivity() {

    private var mBinding: ActivityLoginBinding? = null

    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        signInPage()
        emailCheck()

        binding.idEdt.setOnClickListener {
            binding.idEdt.backgroundTintList =
                ContextCompat.getColorStateList(applicationContext, R.color.black)
        }
    }

    private fun signInPage() {
        binding.signButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun emailCheck() {
        val idPattern: Pattern = android.util.Patterns.EMAIL_ADDRESS
        binding.loginButton.setOnClickListener {
            if (!idPattern.matcher(binding.idEdt.text).matches()) {
                Toast.makeText(this, "이메일 형식을 확인 해 주세요!!", Toast.LENGTH_SHORT).show()
                binding.idEdt.backgroundTintList =
                    ContextCompat.getColorStateList(applicationContext, R.color.red)
                return@setOnClickListener
            }
        }

    }

    override fun onDestroy() {
        mBinding = null
        super.onDestroy()
    }

    private var backPressedTime: Long = 0

    override fun onBackPressed() {
        if (System.currentTimeMillis() - backPressedTime < 2000) {
            finish()
            return
        }

        Toast.makeText(this, "뒤로가기 버튼을 한번 더 누르시면 종료 됩니다.", Toast.LENGTH_SHORT).show()
        backPressedTime = System.currentTimeMillis()
    }
}