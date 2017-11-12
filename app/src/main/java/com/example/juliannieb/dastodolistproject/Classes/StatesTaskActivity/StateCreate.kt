package com.example.juliannieb.dastodolistproject.Classes.StatesTaskActivity

import android.view.View
import com.example.juliannieb.dastodolistproject.Classes.Task
import com.example.juliannieb.dastodolistproject.Classes.TaskActivity
import com.example.juliannieb.dastodolistproject.Classes.ToDoList

/**
 * Created by juliannieb on 11/12/17.
 */

class StateCreate: StateTaskActivity {

    override fun initGUI(taskActivity: TaskActivity, task: Task?) {
        taskActivity.btnSave!!.visibility = View.VISIBLE
        taskActivity.btnDelete!!.visibility = View.GONE
        taskActivity.btnStartTimer!!.visibility = View.GONE

        if (task != null) {
            if (task.title != null) {
                taskActivity.editTxtTitle!!.setText(task.title)
            }

        }
    }

    override fun saveTask(task: Task) {
        ToDoList.instance.addTask(task)
        ToDoList.instance.sortTasks()
    }

}