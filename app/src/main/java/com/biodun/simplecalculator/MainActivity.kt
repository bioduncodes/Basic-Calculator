package com.biodun.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun butClickEvent(view: View){
        if (isNewOp == true){
            etScreen.setText("")
        }
        isNewOp = false
        var butClickedValue: String = etScreen.text.toString()
        val butSelect: Button = view as Button
        when(butSelect.id){

            but0.id -> {
                butClickedValue += "0"
            }
            but1.id -> {
                butClickedValue += "1"
            }
            but2.id -> {
                butClickedValue += "2"
            }
            but3.id -> {
                butClickedValue += "3"
            }
            but4.id -> {
                butClickedValue += "4"
            }
            but5.id -> {
                butClickedValue += "5"
            }
            but6.id -> {
                butClickedValue += "6"
            }
            but7.id -> {
                butClickedValue += "7"
            }
            but8.id -> {
                butClickedValue += "8"
            }
            but9.id -> {
                butClickedValue += "9"
            }
            butDot.id -> {
                //TODO: prevent app from adding multiple dots
                butClickedValue += "."
            }
            butPlusMinus.id -> {
                butClickedValue = "-" + butClickedValue
            }
        }
        etScreen.setText(butClickedValue)
    }


    var op = "*"
    var oldNumber = ""
    var isNewOp = true


    fun butOpEvent(view: View) {
        var butSelect = view as Button
        when(butSelect){
            butDiv -> {
                op = "/"
            }
            butMult -> {
                op = "*"
            }
            butMinus -> {
                op = "-"
            }
            butAdd -> {
                op = "+"
            }
        }
        oldNumber = etScreen.text.toString()
        isNewOp = true
    }

    fun butEqualEvent(view: View){
        var newNumber = etScreen.text.toString()
        var theResult: Double? = null
        when(op){
            "*" -> {
                theResult = oldNumber.toDouble() * newNumber.toDouble()
            }
            "+" -> {
                theResult = oldNumber.toDouble() + newNumber.toDouble()
            }
            "-" -> {
                theResult = oldNumber.toDouble() - newNumber.toDouble()
            }
            "/" -> {
                theResult = oldNumber.toDouble() / newNumber.toDouble()
            }
        }
        etScreen.setText(theResult.toString())
        isNewOp = true
    }

    fun butPercentEvent(view: View){
        var theNumber = etScreen.text.toString().toDouble() / 100
        etScreen.setText(theNumber.toString())
        isNewOp = true
        }

    fun butClear(view: View){
        etScreen.setText("0")
        isNewOp = true
    }
}