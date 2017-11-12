package com.example.juliannieb.dastodolistproject.Classes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.juliannieb.dastodolistproject.Classes.StatesTaskActivity.StateCreate
import com.example.juliannieb.dastodolistproject.Classes.StatesTaskActivity.StateEdit
import com.example.juliannieb.dastodolistproject.Classes.StatesTaskActivity.StateTaskActivity
import com.example.juliannieb.dastodolistproject.R
import com.example.juliannieb.dastodolistproject.Utils

class TaskActivity : AppCompatActivity() {

    var state: StateTaskActivity = StateCreate()
    var task: Task? = null

    var btnSave: Button? = null
    var btnDelete: Button? = null
    var btnStartTimer: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)
        getIntentExtras()
        getLayoutElements()
        initGUI()
    }

    fun getIntentExtras() {
        val bundle = intent.extras
        if(bundle != null) {
            val stateTaskActivity = bundle.getInt("StateTaskActivity")
            if (stateTaskActivity == Utils.StateTaskActivity.STATE_CREATE.ordinal) {
                this.state = StateCreate()
            }
            else if (stateTaskActivity == Utils.StateTaskActivity.STATE_EDIT.ordinal) {
                this.state = StateEdit()
            }
        }
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
