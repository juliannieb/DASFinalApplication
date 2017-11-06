package com.example.juliannieb.dastodolistproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.juliannieb.dastodolistproject.Classes.Timer
import com.example.juliannieb.dastodolistproject.R

class TimerActivity : AppCompatActivity() {

    var timer: Timer = Timer()
    var txtViewTimer: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)
        getLayoutElements()
        timer = Timer(0, 1, 1)
        timer.start { this.txtViewTimer!!.text = timer.toString() }
    }

    override fun onStop() {
        super.onStop()
        timer.stop()
    }

    fun getLayoutElements() {
        this.txtViewTimer = findViewById<TextView>(R.id.txtViewTimer)
    }
}
