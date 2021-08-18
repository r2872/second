package com.example.second

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.second.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mBinding: ActivityMainBinding? = null

    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onDestroy() {
        mBinding = null
        super.onDestroy()
    }
}