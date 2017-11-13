package com.example.juliannieb.dastodolistproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import com.example.juliannieb.dastodolistproject.Classes.*
import com.example.juliannieb.dastodolistproject.Classes.StatesTaskActivity.StateCreate
import com.example.juliannieb.dastodolistproject.Classes.StatesTaskActivity.StateEdit
import com.example.juliannieb.dastodolistproject.Classes.StatesTaskActivity.StateTaskActivity

class TaskActivity : AppCompatActivity() {

    var state: StateTaskActivity = StateCreate()
    var task: Task? = null
    val handler = Handler()

    var editTxtTitle: EditText? = null
    var editTxtDescription: EditText? = null
    var radioGroupPriority: RadioGroup? = null
    var editTxtInterval: EditText? = null
    var btnSave: Button? = null
    var btnDelete: Button? = null
    var btnStartTimer: Button? = null
    var btnComplete: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)
        getIntentExtras()
        getLayoutElements()
        setLayoutElements()
        initGUI()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        handler.removeCallbacksAndMessages(null)
        setTask()
        this.state.onBackPressed(task!!)
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
                task = TaskFactory().id(ToDoList.instance.currId).build()
                ToDoList.instance.draft = task!!.saveMemento()
                ToDoList.instance.sortTasks()
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
        btnComplete = findViewById<Button>(R.id.btnComplete)
    }

    fun setLayoutElements() {
        btnSave!!.setOnClickListener(View.OnClickListener {
            saveTask()
            this.finish()
        })
        btnDelete!!.setOnClickListener(View.OnClickListener {
            val idx = ToDoList.instance.getTaskIdx(task!!)
            if (idx != -1) {
                ToDoList.instance.tasks.removeAt(idx)
                ToDoList.instance.save(this)
                this.finish()
            }
        })
        btnStartTimer!!.setOnClickListener(View.OnClickListener {
            handler.postDelayed(Runnable {
                showSimpleAlert("Done", "The interval has finished.", "OK")
                task!!.timeWorkedOn += task!!.intervalTime
                this.state.saveTask(task!!)
                ToDoList.instance.save(this)
            }, task!!.intervalTime)
        })
        btnComplete!!.setOnClickListener(View.OnClickListener {
            task!!.priority = Priority.COMPLETED
            this.state.saveTask(task!!)
            ToDoList.instance.save(this)
            this.finish()
        })
    }

    fun initGUI() {
        this.state.initGUI(this, task)
    }

    fun saveTask() {
        setTask()
        this.state.saveTask(task!!)
        ToDoList.instance.save(this)
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

    fun showSimpleAlert(title: String, message: String, buttonText: String) {
        val simpleAlert = AlertDialog.Builder(this@TaskActivity).create()
        simpleAlert.setTitle(title)
        simpleAlert.setMessage(message)

        simpleAlert.setButton(AlertDialog.BUTTON_POSITIVE, buttonText, {
            dialogInterface, i ->

        })

        simpleAlert.show()
    }
}
