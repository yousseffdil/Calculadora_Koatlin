package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    // Funcion que recibe un parametro de la vista
    fun onclickDigit(view : View){
        val tv_num2 : TextView = findViewById(R.id.tv_2)
        val num2 : Double = tv_num2.text.toString().toDouble()

    }
}