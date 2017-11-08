package com.example.juliannieb.dastodolistproject.Classes.StrategiesToDoList

import com.example.juliannieb.dastodolistproject.Classes.ToDoList

/**
 * Created by juliannieb on 11/7/17.
 */

class StrategyPriority: StrategyToDoList {

    override fun sortTasks() {
        ToDoList.instance.tasks.sortWith(compareBy({it.priority}))
    }

}