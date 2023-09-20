package com.example.myapplication

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    /*
    0 = null
    1 = +
    2 = -
    3 = *
    4 = /
    * */
    var oper : Int = 0
    var numero1 : Double = 0.0
    lateinit var tv_num1: TextView
    lateinit var tv_num2: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_num1 =  findViewById(R.id.tv_1)
        tv_num2 =  findViewById(R.id.tv_2)

        val bresult : Button = findViewById(R.id.bresult)
        val brefresh : Button = findViewById(R.id.brefresh)


        bresult.setOnClickListener{
            var numero2 : Double = tv_num2.text.toString().toDouble()
            var  resp: Double = 0.0

            when(oper){
                1 -> resp = numero1 + numero2
                2 -> resp = numero1 - numero2
                3 -> resp = numero1 * numero2
                4 -> resp = numero1 / numero2
            }



            if(resp.isInfinite()){
                tv_num1.setText("ERROR")
                tv_num2.setText("No es pot dividir un numero per 0")
            }else{
                tv_num1.setText(resp.toString())
            }
        }

        brefresh.setOnClickListener{
            tv_num1.setText("")
            tv_num2.setText("")
            numero1 = 0.0
            oper = 0
        }

    }

    // Funcion que recibe un parametro de la vista
    fun onclickDigit(view : View){
        // val tv_num2 : TextView = findViewById(R.id.tv_2)
        val num2 : String = tv_num2.text.toString()

        when(view.id){
            R.id.b0 -> tv_num2.setText(num2 + "0")
            R.id.b1 -> tv_num2.setText(num2 + "1")
            R.id.b2 -> tv_num2.setText(num2 + "2")

            R.id.b3 -> tv_num2.setText(num2 + "3")
            R.id.b4 -> tv_num2.setText(num2 + "4")
            R.id.b5 -> tv_num2.setText(num2 + "5")

            R.id.b6 -> tv_num2.setText(num2 + "6")
            R.id.b7 -> tv_num2.setText(num2 + "7")
            R.id.b8 -> tv_num2.setText(num2 + "8")
            R.id.b9 -> tv_num2.setText(num2 + "9")

            R.id.bpun -> tv_num2.setText(num2 + ".")

        }
    }
    fun OnclickOperation(view: View){
        numero1 = tv_num2.text.toString().toDouble()
        var num2_Text : String = tv_num2.text.toString()
        tv_num2.setText("")
        when(view.id){
            R.id.bplus ->{
                tv_num1.setText(num2_Text + "+")
                oper = 1
            }
            R.id.bmin ->{
                tv_num1.setText(num2_Text + "-")
                oper = 2
            }
            R.id.badd ->{
                tv_num1.setText(num2_Text + "x")
                oper = 3
            }
            R.id.bdiv ->{
                tv_num1.setText(num2_Text + "/")
                oper = 4
            }
        }
    }
}