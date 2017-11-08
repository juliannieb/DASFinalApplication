package com.example.juliannieb.dastodolistproject.Classes.StrategiesToDoList

import com.example.juliannieb.dastodolistproject.Classes.ToDoList

/**
 * Created by juliannieb on 11/7/17.
 */

class StrategySortAlphabetically: StrategyToDoList {

    override fun sortTasks() {
        ToDoList.instance.tasks.sortedWith(compareBy({it.title}))
    }

}