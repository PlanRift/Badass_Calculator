package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var edtLength : EditText
    private lateinit var edtWidth : EditText
    private lateinit var edtHeight : EditText
    private lateinit var btnResult : Button
    private lateinit var tvResult : TextView
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        installSplashScreen()
        setContentView(binding.root)

        edtLength = binding.edtLength
        edtWidth = binding.edtWide
        edtHeight = binding.edtHeight
        btnResult = binding.btnResult
        tvResult = binding.tvResult

        btnResult.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        when (view?.id){
            R.id.btn_result ->{
            val getLength = edtLength.text.toString().trim()
            val getWidth = edtWidth.text.toString().trim()
            val getHeight = edtHeight.text.toString().trim()
            val msg = "JANGAN KOSONG"
            if (getLength.isEmpty()){
                edtLength.error = msg
                return
            }

            if (getWidth.isEmpty()){
                edtWidth.error = msg
                return
            }

            if (getHeight.isEmpty()){
                edtHeight.error = msg
                return
            }

            val hasil = getLength.toDouble() * getWidth.toDouble() * getHeight.toDouble()
            tvResult.text = hasil.toString()

            val intent = Intent(this@MainActivity,result::class.java)
            intent.putExtra(result.result, tvResult.text)
                startActivity(intent)
            }
        }
    }


}