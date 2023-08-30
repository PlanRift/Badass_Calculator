package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var edtLength : EditText
    private lateinit var edtWidth : EditText
    private lateinit var edtHeight : EditText
    private lateinit var btnResult : Button
    private lateinit var tvResult : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_main)

        edtLength = findViewById(R.id.edt_length)
        edtWidth = findViewById(R.id.edt_wide)
        edtHeight = findViewById(R.id.edt_height)
        btnResult = findViewById(R.id.btn_result)
        tvResult = findViewById(R.id.tv_result)

        btnResult.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.btn_result){
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

            val result = getLength.toDouble() * getWidth.toDouble() * getHeight.toDouble()
            tvResult.text = result.toString()
        }
    }
}