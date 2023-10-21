package com.example.userinput

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mealCost = findViewById<EditText>(R.id.editTextCost)
        val tipPercent = findViewById<Spinner>(R.id.spinnerTipPercent)
        val calcTip = findViewById<Button>(R.id.buttonCalculate)
        val tipAmount = findViewById<TextView>(R.id.textTipAmount)
        calcTip.setOnClickListener {
            val mealCostDouble = mealCost.text.toString().toDouble()
            val tipPercentInt = tipPercent.selectedItem.toString().toInt()
            val tipPercentDouble = tipPercentInt.toDouble() / 100
            val tipAmountDouble = mealCostDouble * tipPercentDouble
            val decimalFormat = DecimalFormat("#,###.00")
            tipAmount.setText("Meal Cost: $$mealCostDouble\nTip Percent: $tipPercentInt%\nTip Amount: $${decimalFormat.format(tipAmountDouble)}")
        }
    }
}