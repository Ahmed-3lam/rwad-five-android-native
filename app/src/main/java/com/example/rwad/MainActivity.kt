package com.example.rwad

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.provider.CalendarContract.Colors
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.rwad.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var counter =0
    override fun onCreate(savedInstanceState: Bundle?) {
        Logger.addLogAdapter( AndroidLogAdapter())
        Logger.i("LifeCycle: On Create")
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

    }

    override fun onStart() {
        Logger.i("LifeCycle: On Start")

        super.onStart()
    }

    override fun onResume() {
        Logger.i("LifeCycle: On Resume")
        super.onResume()
    }

    override fun onPause() {
        Logger.i("LifeCycle: On Pause")

        super.onPause()
    }

    override fun onStop() {
        Logger.i("LifeCycle: On Stop")

        super.onStop()
    }

    override fun onDestroy() {
        Logger.i("LifeCycle: On Destroy")

        super.onDestroy()
    }

}

