package com.example.juliannieb.dastodolistproject.Classes.StrategiesToDoList

import com.example.juliannieb.dastodolistproject.Classes.ToDoList

/**
 * Created by juliannieb on 11/12/17.
 */

class StrategyTotalTime: StrategyToDoList {

    /**
     * Sort tasks list according to the time worked on them.
     *
     */
    override fun sortTasks() {
        ToDoList.instance.tasks.sortWith(compareBy({it.timeWorkedOn}))
    }

}