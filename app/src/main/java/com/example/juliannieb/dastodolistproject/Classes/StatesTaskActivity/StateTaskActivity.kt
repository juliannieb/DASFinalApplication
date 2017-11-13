package com.example.juliannieb.dastodolistproject.Classes.StatesTaskActivity

import com.example.juliannieb.dastodolistproject.Classes.Task
import com.example.juliannieb.dastodolistproject.TaskActivity

/**
 * Created by juliannieb on 11/12/17.
 */

interface StateTaskActivity {

    /**
     * Init the GUI components of the layout according to the current state.
     *
     * @param taskActivity TaskActivity context
     * @param task current task of the TaskActivity that's being edited
     */
    fun initGUI(taskActivity: TaskActivity, task: Task?)

    /**
     * Save task according to the current state.
     *
     * @param task Task to be saved
     */
    fun saveTask(task: Task)

    /**
     * Override onBackPressed functionality if necessary.
     *
     * @param task current Task of the context
     */
    fun onBackPressed(task: Task)
}