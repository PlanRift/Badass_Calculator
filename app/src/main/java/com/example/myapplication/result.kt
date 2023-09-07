package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ActivityResultBinding

class result : AppCompatActivity() {

    private lateinit var tvResultData : TextView
    private lateinit var binding : ActivityResultBinding

    companion object {
        const val result = "result"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tvResultData = binding.resultIntent

        val resultData = intent.getStringExtra(result)

        tvResultData.text = resultData
    }
}