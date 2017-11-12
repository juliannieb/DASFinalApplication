package com.example.juliannieb.dastodolistproject.Classes.StatesTaskActivity

import android.view.View
import com.example.juliannieb.dastodolistproject.Classes.Task
import com.example.juliannieb.dastodolistproject.Classes.TaskActivity
import com.example.juliannieb.dastodolistproject.Classes.ToDoList

/**
 * Created by juliannieb on 11/12/17.
 */

class StateEdit: StateTaskActivity {
    override fun initGUI(taskActivity: TaskActivity, task: Task?) {
        taskActivity.btnSave!!.visibility = View.VISIBLE
        taskActivity.btnDelete!!.visibility = View.VISIBLE
        taskActivity.btnStartTimer!!.visibility = View.VISIBLE
    }

    override fun saveTask(task: Task) {
        val idx = ToDoList.instance.getTaskIdx(task)
        ToDoList.instance.tasks.set(idx, task)
        ToDoList.instance.sortTasks()
    }

}