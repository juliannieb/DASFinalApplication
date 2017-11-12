package com.example.juliannieb.dastodolistproject.Classes.StatesTaskActivity

import com.example.juliannieb.dastodolistproject.Classes.Task
import com.example.juliannieb.dastodolistproject.Classes.TaskActivity

/**
 * Created by juliannieb on 11/12/17.
 */

interface StateTaskActivity {

    fun initGUI(taskActivity: TaskActivity, task: Task?)

    fun saveTask(task: Task)

}