package com.example.rwad

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.provider.CalendarContract.Colors
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val maleBtn: Button = findViewById(R.id.maleBtn)
        val femleBtn: Button = findViewById(R.id.femaleBtn)
        val heightText: TextView = findViewById(R.id.heightTxt)
        val weightText: TextView = findViewById(R.id.weightTxt)
        val heightSeekBar: SeekBar = findViewById(R.id.heightSeekBar)
        val weightSeekBar: SeekBar = findViewById(R.id.weightSeekBar)
        val calculateBtn: Button = findViewById(R.id.calcBtn)
        var selectedGender = Gender.FEMALE
        var selectedHeight = 0.0
        var selectedWeight = 0.0

        maleBtn.setOnClickListener() {
            maleBtn.setBackgroundColor(Color.parseColor("#2196F3"))
            femleBtn.setBackgroundColor(Color.parseColor("#5F6162"))
            selectedGender = Gender.MALE
        }

        femleBtn.setOnClickListener() {
            femleBtn.setBackgroundColor(Color.parseColor("#2196F3"))
            maleBtn.setBackgroundColor(Color.parseColor("#5F6162"))
            selectedGender = Gender.FEMALE
        }

        heightSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                heightText.text = "Height: $progress cm"
                selectedHeight = progress.toDouble()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // Do something
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Do something
            }
        })

        weightSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                weightText.text = "Weight: $progress kg"
                selectedWeight = progress.toDouble()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // Do something
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Do something
            }
        })
        calculateBtn.setOnClickListener() {
            val bmi: Double = selectedWeight / (selectedHeight / 100 * selectedHeight / 100)
            val result = when (bmi) {
                in 0.0..18.5 -> "Underweight"
                in 18.0..24.9 -> "Normal weight"
                in 25.0..29.9 -> "Overweight"
                in 30.0..34.9 -> "Obesity class 1"
                in 35.0..39.9 -> "Obesity class 2"
                else -> "Obesity class 3"
            }
            AlertDialog.Builder(this).setTitle("Result")
                .setMessage("Your BMI is ${bmi.toInt()} and you are $result")
                .setPositiveButton("OK") { dialog, which -> }.show()
        }


    }


}

enum class Gender {
    MALE, FEMALE
}