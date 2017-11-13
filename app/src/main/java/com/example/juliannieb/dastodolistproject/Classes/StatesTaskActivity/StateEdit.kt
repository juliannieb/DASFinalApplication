package com.example.juliannieb.dastodolistproject.Classes.StatesTaskActivity

import android.view.View
import com.example.juliannieb.dastodolistproject.Classes.Priority
import com.example.juliannieb.dastodolistproject.Classes.Task
import com.example.juliannieb.dastodolistproject.TaskActivity
import com.example.juliannieb.dastodolistproject.Classes.ToDoList
import com.example.juliannieb.dastodolistproject.R

/**
 * Created by juliannieb on 11/12/17.
 */

class StateEdit: StateTaskActivity {
    override fun initGUI(taskActivity: TaskActivity, task: Task?) {
        taskActivity.btnSave!!.visibility = View.VISIBLE
        taskActivity.btnDelete!!.visibility = View.VISIBLE
        taskActivity.btnStartTimer!!.visibility = View.VISIBLE

        if (task != null) {
            if (task.title != null) {
                taskActivity.editTxtTitle!!.setText(task.title)
            }
            if (task.description != null) {
                taskActivity.editTxtDescription!!.setText(task.description)
            }
            if (task.priority != null) {
                if (task.priority == Priority.LOW) {
                    taskActivity.radioGroupPriority!!.check(R.id.btnPriorityLow)
                }
                else if (task.priority == Priority.MEDIUM) {
                    taskActivity.radioGroupPriority!!.check(R.id.btnPriorityMedium)
                }
                else if (task.priority == Priority.HIGH) {
                    taskActivity.radioGroupPriority!!.check(R.id.btnPriorityHigh)
                }
            }
            if (task.intervalTime != null) {
                taskActivity.editTxtInterval!!.setText(task.intervalTime.toString())
            }
        }
    }

    override fun saveTask(task: Task) {
        val idx = ToDoList.instance.getTaskIdx(task)
        ToDoList.instance.tasks.set(idx, task)
        ToDoList.instance.sortTasks()
    }

    override fun onBackPressed(task: Task) {

    }

}