package com.akram.significantcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.lang.Math.*

class MainActivity : AppCompatActivity() {

    lateinit var multiplication: Button
    lateinit var div: Button
    lateinit var minus: Button
    lateinit var plus11: Button
    lateinit var equal: Button
    lateinit var result: TextView
    lateinit var clear: Button
    lateinit var perc: Button
    lateinit var sin: Button
    lateinit var cos: Button
    lateinit var tan: Button
    lateinit var asin: Button
    lateinit var acos: Button
    lateinit var atan: Button
    lateinit var ln: Button
    lateinit var log: Button
    var lasrNumber: Double = 0.0
    var currenOperation: operation? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        addCallBackes()
    }

    private fun addCallBackes() {
        clear.setOnClickListener {
            clear()
        }
        multiplication.setOnClickListener {
            prepareOperation(operation.mul)
        }
        div.setOnClickListener {
            prepareOperation(operation.div)
        }
        minus.setOnClickListener {
            prepareOperation(operation.minus)
        }
        plus11.setOnClickListener {
            prepareOperation(operation.plus)
        }
        perc.setOnClickListener {
            prepareOperation(operation.perc)
        }
        sin.setOnClickListener {
            prepareOperation(operation.sin)
        }
        cos.setOnClickListener {
            prepareOperation(operation.cos)
        }
        tan.setOnClickListener {
            prepareOperation(operation.tan)
        }
        asin.setOnClickListener {
            prepareOperation(operation.asin)
        }
        tan.setOnClickListener {
            prepareOperation(operation.tan)
        }
        atan.setOnClickListener {
            prepareOperation(operation.atan)
        }
        log.setOnClickListener {
            prepareOperation(operation.log)
        }
        equal.setOnClickListener {
           val answer = doCurrentOperation()
            result.text = answer.toString()
        }


    }

    private fun doCurrentOperation(): Double {
        val secondNumber = result.text.toString().toDouble()
        return when(currenOperation) {
            operation.plus -> lasrNumber + secondNumber
            operation.minus -> lasrNumber - secondNumber
            operation.div -> lasrNumber / secondNumber
            operation.mul -> lasrNumber * secondNumber
            operation.sin -> sin(secondNumber)
            operation.cos -> cos(secondNumber)
            operation.asin -> asin(secondNumber)
            operation.acos -> acos(secondNumber)
            operation.tan -> tan(secondNumber)
            operation.atan -> atan(secondNumber)
            operation.log -> log(secondNumber)
            operation.perc -> secondNumber / 100
            null -> 0.0
            operation.ln -> TODO()
        }
    }

    private fun clear() {
        result.text = ""
    }

    private fun initView() {
        minus = findViewById(R.id.minus)
        multiplication = findViewById(R.id.multiplication)
        div = findViewById(R.id.div)
        plus11 = findViewById(R.id.plus11)
        equal = findViewById(R.id.equl)
        result = findViewById(R.id.result)
        clear = findViewById(R.id.clear)
        perc = findViewById(R.id.perc)
        sin = findViewById(R.id.sin)
        cos = findViewById(R.id.cos)
        tan = findViewById(R.id.tan)
        asin = findViewById(R.id.asin)
        acos = findViewById(R.id.acos)
        atan = findViewById(R.id.atan)
        log = findViewById(R.id.log)



    }
    fun prepareOperation(operation: operation) {
        lasrNumber = result.text.toString().toDouble()
        clear()
        currenOperation = operation
    }

    fun onClickNumber(v:  View) {
        val newDigit = (v as Button).text.toString()
        val oldDigit = result.text.toString()
        val newResut = newDigit + oldDigit
        result.text = newResut


    }
}