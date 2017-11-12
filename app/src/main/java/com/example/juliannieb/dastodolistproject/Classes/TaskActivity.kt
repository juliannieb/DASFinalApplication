package com.example.juliannieb.dastodolistproject.Classes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.juliannieb.dastodolistproject.Classes.StatesTaskActivity.StateCreate
import com.example.juliannieb.dastodolistproject.Classes.StatesTaskActivity.StateEdit
import com.example.juliannieb.dastodolistproject.Classes.StatesTaskActivity.StateTaskActivity
import com.example.juliannieb.dastodolistproject.R

class TaskActivity : AppCompatActivity() {

    var state: StateTaskActivity = StateEdit()
    var task: Task? = null

    var btnSave: Button? = null
    var btnDelete: Button? = null
    var btnStartTimer: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)
        getLayoutElements()
        initGUI()
    }

    fun getLayoutElements() {
        btnSave = findViewById<Button>(R.id.btnSave)
        btnDelete = findViewById<Button>(R.id.btnDelete)
        btnStartTimer = findViewById<Button>(R.id.btnStartTimer)
    }

    fun initGUI() {
        this.state.initGUI(this, task)
    }
}
