package com.mo7ammedtabasi.currencyconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import com.mo7ammedtabasi.currencyconverter.databinding.ActivityMainBinding
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    private val americanDollar = "American dollar"
    private val egyptianPound = "Egyptian Pound"
    private val AED = "AED"
    private val GBP = "GBP"
    private lateinit var toDropDownMenu:AutoCompleteTextView
    private lateinit var fromDropDownMenu:AutoCompleteTextView
    private var amount:Double? = 0.0
    private var result:Double? = 0.0

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dropDownMenu()

        binding.convertButton.setOnClickListener {
            amount = binding.amountEditText.text.toString().toDouble()
            val currentToField = toDropDownMenu.text.toString()
            result = when (currentToField) {
                egyptianPound -> {
                    amount!!.times(15.73)
                }
                AED -> {
                    amount!!.times(3.67)
                }
                GBP -> {
                    amount!!.times(0.74)
                }
                else -> {
                    amount!!.times(1)
                }
            }
            binding.resultEd.setText(result.toString())
        }
    }

    private fun dropDownMenu(){
        toDropDownMenu = binding.toCurrencyMenu
        fromDropDownMenu= binding.fromCurrencyMenu
        val listOfCountry = listOf(americanDollar,egyptianPound,AED,GBP)
        val adapter = ArrayAdapter(this,R.layout.drop_down_list_item,listOfCountry)
        toDropDownMenu.setAdapter(adapter)
        fromDropDownMenu.setAdapter(adapter)
    }
}