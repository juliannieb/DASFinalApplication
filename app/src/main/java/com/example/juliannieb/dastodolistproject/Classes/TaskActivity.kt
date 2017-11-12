package com.example.juliannieb.dastodolistproject.Classes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import com.example.juliannieb.dastodolistproject.Classes.StatesTaskActivity.StateCreate
import com.example.juliannieb.dastodolistproject.Classes.StatesTaskActivity.StateEdit
import com.example.juliannieb.dastodolistproject.Classes.StatesTaskActivity.StateTaskActivity
import com.example.juliannieb.dastodolistproject.R
import com.example.juliannieb.dastodolistproject.Utils

class TaskActivity : AppCompatActivity() {

    var state: StateTaskActivity = StateCreate()
    var task: Task? = null

    var editTxtTitle: EditText? = null
    var editTxtDescription: EditText? = null
    var radioGroupPriority: RadioGroup? = null
    var editTxtInterval: EditText? = null
    var btnSave: Button? = null
    var btnDelete: Button? = null
    var btnStartTimer: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)
        getIntentExtras()
        getLayoutElements()
        setLayoutElements()
        initGUI()
    }

    fun getIntentExtras() {
        val bundle = intent.extras
        if(bundle != null) {
            val stateTaskActivity = bundle.getInt("StateTaskActivity")
            if (stateTaskActivity != null) {
                if (stateTaskActivity == Utils.StateTaskActivity.STATE_CREATE.ordinal) {
                    this.state = StateCreate()
                }
                else if (stateTaskActivity == Utils.StateTaskActivity.STATE_EDIT.ordinal) {
                    this.state = StateEdit()
                }
            }
            if (bundle.getSerializable("task") != null) {
                val taskSerializable = bundle.getSerializable("task") as DataTask
                task = Task(taskSerializable)
            }
            else {
                task = TaskFactory().id(0).build()
                ToDoList.instance.draft = task!!.saveMemento()
            }
        }
    }

    fun getLayoutElements() {
        editTxtTitle = findViewById<EditText>(R.id.editTxtTitle)
        editTxtDescription = findViewById<EditText>(R.id.editTxtDescription)
        radioGroupPriority = findViewById<RadioGroup>(R.id.radioGroupPriority)
        editTxtInterval = findViewById<EditText>(R.id.editTxtInterval)
        btnSave = findViewById<Button>(R.id.btnSave)
        btnDelete = findViewById<Button>(R.id.btnDelete)
        btnStartTimer = findViewById<Button>(R.id.btnStartTimer)
    }

    fun setLayoutElements() {
        btnSave!!.setOnClickListener(View.OnClickListener {
            saveTask()
            this.finish()
        })
    }

    fun initGUI() {
        this.state.initGUI(this, task)
    }

    fun saveTask() {
        setTask()
        this.state.saveTask(task!!)
    }

    fun setTask() {
        val title = editTxtTitle!!.text.toString()
        val description = editTxtDescription!!.text.toString()
        val priorityId = radioGroupPriority!!.checkedRadioButtonId
        var priority = Priority.LOW
        if (priorityId == R.id.btnPriorityLow) {
            priority = Priority.LOW
        }
        else if (priorityId == R.id.btnPriorityMedium) {
            priority = Priority.MEDIUM
        }
        else if (priorityId == R.id.btnPriorityHigh) {
            priority = Priority.HIGH
        }
        val interval = editTxtInterval!!.text.toString().toLong()

        task!!.title = title
        task!!.description = description
        task!!.priority = priority
        task!!.intervalTime = interval
    }
}
