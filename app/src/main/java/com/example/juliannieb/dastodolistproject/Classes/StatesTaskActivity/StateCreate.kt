package com.example.juliannieb.dastodolistproject.Classes.StatesTaskActivity

import android.view.View
import com.example.juliannieb.dastodolistproject.Classes.Task
import com.example.juliannieb.dastodolistproject.Classes.TaskActivity

/**
 * Created by juliannieb on 11/12/17.
 */

class StateCreate: StateTaskActivity {

    override fun initGUI(taskActivity: TaskActivity, task: Task?) {
        taskActivity.btnSave!!.visibility = View.VISIBLE
        taskActivity.btnDelete!!.visibility = View.GONE
        taskActivity.btnStartTimer!!.visibility = View.GONE
    }

    override fun saveTask(task: Task) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}