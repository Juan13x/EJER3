package com.juanguicj.ejer3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.juanguicj.ejer3.databinding.ActivityMainBinding
import java.util.*
import java.util.zip.Inflater
import kotlin.concurrent.timerTask

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    private val timer = Timer()
    private val usd = 3944.4f
    private val eur = 4133.47f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        with(mainBinding){
            solveButton.setOnClickListener {
                val currency1 = currency1EditText.text.toString()

                if(currency1.isNullOrEmpty()){
                    currency1EditText.setHintTextColor(resources.getColor(R.color.main_currency_empty))
                    resultTextView.text = getString(R.string.main_solve_currency_empty)
                    timer.schedule(
                        timerTask {
                            currency1EditText.setHintTextColor(resources.getColor(R.color
                                .main_currency_hint))
                            resultTextView.text = ""
                        },
                        1000
                    )

                } else{
                    val choiceCurrency1 = choice1Spinner.selectedItem.toString()
                    val choiceCurrency2 = choice2Spinner.selectedItem.toString()

                    var valueCurrency1 = currency1.toFloat()
                    var result = 0
                    when (choiceCurrency1){
                        "USD" -> valueCurrency1 *= usd
                        "EUR" -> valueCurrency1 *= eur
                    }

                    when (choiceCurrency2){
                        "USD" -> valueCurrency1 /= usd
                        "EUR" -> valueCurrency1 /= eur
                    }
                    resultTextView.text = valueCurrency1.toString()
                }
            }
        }
    }
}