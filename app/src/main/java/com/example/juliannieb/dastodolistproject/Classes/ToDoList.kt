package com.example.juliannieb.dastodolistproject.Classes

/**
 * Created by juliannieb on 11/7/17.
 */

class ToDoList {

    var tasks: ArrayList<Task> = ArrayList<Task>()

    private constructor() {

    }

    private object Holder {val INSTANCE = ToDoList()}

    companion object {
        val instance: ToDoList by lazy { Holder.INSTANCE }
    }

}