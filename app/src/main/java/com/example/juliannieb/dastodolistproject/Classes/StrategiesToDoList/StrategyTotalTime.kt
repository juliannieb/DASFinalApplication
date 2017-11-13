package com.example.juliannieb.dastodolistproject.Classes.StrategiesToDoList

import com.example.juliannieb.dastodolistproject.Classes.ToDoList

/**
 * Created by juliannieb on 11/12/17.
 */

class StrategyTotalTime: StrategyToDoList {

    override fun sortTasks() {
        ToDoList.instance.tasks.sortWith(compareBy({it.timeWorkedOn}))
    }

}