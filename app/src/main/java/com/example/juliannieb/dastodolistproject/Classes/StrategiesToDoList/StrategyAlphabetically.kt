package com.example.juliannieb.dastodolistproject.Classes.StrategiesToDoList

import com.example.juliannieb.dastodolistproject.Classes.ToDoList

/**
 * Created by juliannieb on 11/7/17.
 */

class StrategyAlphabetically: StrategyToDoList {

    /**
     * Sort tasks list according to their title.
     *
     */
    override fun sortTasks() {
        ToDoList.instance.tasks.sortWith(compareBy({it.title}))
    }

}