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

        val rollBtn: Button = findViewById(R.id.rollButton)

        rollBtn.setOnClickListener() {
            rollDice()
        }


    }

    private fun rollDice() {
        val image: ImageView = findViewById(R.id.imageView)
        val randomInt = (1..6).random()
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        image.setImageResource(drawableResource)

    }

}