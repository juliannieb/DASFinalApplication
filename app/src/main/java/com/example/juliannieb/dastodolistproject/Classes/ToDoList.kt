package com.example.juliannieb.dastodolistproject.Classes

import com.example.juliannieb.dastodolistproject.Classes.StrategiesToDoList.StrategyPriority
import com.example.juliannieb.dastodolistproject.Classes.StrategiesToDoList.StrategyToDoList

/**
 * Created by juliannieb on 11/7/17.
 */

class ToDoList {

    var tasks: ArrayList<Task> = ArrayList<Task>()
    var draft: DataTask? = null
    var strategyToDoList: StrategyToDoList = StrategyPriority()

    private constructor() {

    }

    private object Holder {val INSTANCE = ToDoList()}

    companion object {
        val instance: ToDoList by lazy { Holder.INSTANCE }
    }

    fun sortTasks() {
        this.strategyToDoList.sortTasks()
    }

}