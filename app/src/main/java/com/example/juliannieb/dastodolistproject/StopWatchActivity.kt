package com.example.juliannieb.dastodolistproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.juliannieb.dastodolistproject.Classes.StopWatch

class StopWatchActivity : AppCompatActivity() {

    var stopWatch: StopWatch = StopWatch()

    var txtViewStopWatch: TextView? = null
    var btnStart: Button? = null
    var btnPause: Button? = null
    var btnStop: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stop_watch)
        getLayoutElements()
        setElementsListeners()
    }

    fun getLayoutElements() {
        this.txtViewStopWatch = findViewById<TextView>(R.id.txtViewStopWatch)
        this.btnStart = findViewById<Button>(R.id.btnStart)
        this.btnPause = findViewById<Button>(R.id.btnPause)
        this.btnStop = findViewById<Button>(R.id.btnStop)
    }

    fun setElementsListeners() {
        this.btnStart!!.setOnClickListener(View.OnClickListener {
            this.stopWatch.start { this.txtViewStopWatch!!.text = this.stopWatch.toString() }
        })
        this.btnPause!!.setOnClickListener(View.OnClickListener {
            this.stopWatch.pause()
        })
        this.btnStop!!.setOnClickListener(View.OnClickListener {
            this.stopWatch.stop { this.txtViewStopWatch!!.text = this.stopWatch.toString() }
        })
    }
}
