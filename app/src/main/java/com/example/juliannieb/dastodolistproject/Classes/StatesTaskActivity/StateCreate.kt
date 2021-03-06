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

class StateCreate: StateTaskActivity {

    /**
     * Hide some buttons, fills Task form with current task data.
     *
     * @param taskActivity TaskActivity context
     * @param task current task of the TaskActivity that's being edited
     */
    override fun initGUI(taskActivity: TaskActivity, task: Task?) {
        taskActivity.btnSave!!.visibility = View.VISIBLE
        taskActivity.btnDelete!!.visibility = View.GONE
        taskActivity.btnStartTimer!!.visibility = View.GONE
        taskActivity.btnComplete!!.visibility = View.GONE

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

    /**
     * Save a new task in the ToDoList.
     *
     * @param task Task to be saved
     */
    override fun saveTask(task: Task) {
        ToDoList.instance.addTask(task)
        ToDoList.instance.sortTasks()
        ToDoList.instance.draft = null
        ToDoList.instance.currId++
    }

    /**
     * Save task draft to memento.
     *
     * @param task Task to be saved as a memento
     */
    override fun onBackPressed(task: Task) {
        ToDoList.instance.draft = task.saveMemento()
    }

}