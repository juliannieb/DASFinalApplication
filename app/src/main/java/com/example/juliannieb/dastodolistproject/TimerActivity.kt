package com.example.juliannieb.dastodolistproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.juliannieb.dastodolistproject.Classes.Timer

class TimerActivity : AppCompatActivity() {

    var timer: Timer = Timer()

    var editTxtHours: EditText? = null
    var editTxtMinutes: EditText? = null
    var editTxtSeconds: EditText? = null
    var txtViewTimer: TextView? = null
    var btnStart: Button? = null
    var btnPause: Button? = null
    var btnStop: Button? = null

    /**
     * Overrides method when the activity is created.
     *
     * @param savedInstanceState the saved bundle
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)
        getLayoutElements()
        setElementsListeners()
    }

    /**
     * Overrides method when the activity is stoped.
     *
     */
    override fun onStop() {
        super.onStop()
        timer.stop {  }
    }

    /**
     * Get GUI elements from the layout.
     *
     */
    fun getLayoutElements() {
        this.editTxtHours = findViewById<EditText>(R.id.editTxtHours)
        this.editTxtMinutes = findViewById<EditText>(R.id.editTxtMinutes)
        this.editTxtSeconds = findViewById<EditText>(R.id.editTxtSeconds)
        this.txtViewTimer = findViewById<TextView>(R.id.txtViewTimer)
        this.btnStart = findViewById<Button>(R.id.btnStart)
        this.btnPause = findViewById<Button>(R.id.btnPause)
        this.btnStop = findViewById<Button>(R.id.btnStop)
    }

    /**
     * Set the OnClick listeners for the layout buttons.
     *
     */
    fun setElementsListeners() {
        this.btnStart!!.setOnClickListener(View.OnClickListener {
            startTimer()
        })
        this.btnPause!!.setOnClickListener(View.OnClickListener {
            this.timer.pause()
        })
        this.btnStop!!.setOnClickListener(View.OnClickListener {
            this.timer.stop { this.txtViewTimer!!.text = timer.toString() }
        })
    }

    /**
     * Set the initial values for the timer and starts ticking it backwards every second.
     *
     */
    fun startTimer() {
        if (this.timer.hour != 0 || this.timer.minute != 0 || this.timer.second != 0) {
            timer.start { this.txtViewTimer!!.text = timer.toString() }
        }
        else {
            var hours = 0
            var minutes = 0
            var seconds = 0
            val hoursString = this.editTxtHours!!.text.toString()
            val minutesString = this.editTxtMinutes!!.text.toString()
            val secondsString = this.editTxtSeconds!!.text.toString()
            if (hoursString == null || hoursString.equals("") ||
                    minutesString == null || minutesString.equals("") ||
                    secondsString == null || secondsString.equals("")) {
                showSimpleAlert("Warning", "Please provide valid inputs", "OK")
                return
            }
            hours = hoursString.toInt()
            minutes = minutesString.toInt()
            seconds = secondsString.toInt()

            timer.setWatch(hours, minutes, seconds)
            timer.start { this.txtViewTimer!!.text = timer.toString() }
        }
    }

    /**
     * Show a simple alert dialog with one button.
     *
     * @param title string representing the title of the alert dialog
     * @param message string representing the message of the alert dialog
     * @param buttonText string representing the messaage of the button of the alert dialog
     */
    fun showSimpleAlert(title: String, message: String, buttonText: String) {
        val simpleAlert = AlertDialog.Builder(this@TimerActivity).create()
        simpleAlert.setTitle(title)
        simpleAlert.setMessage(message)

        simpleAlert.setButton(AlertDialog.BUTTON_POSITIVE, buttonText, {
            dialogInterface, i ->

        })

        simpleAlert.show()
    }
}
