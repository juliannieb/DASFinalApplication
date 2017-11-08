package com.example.juliannieb.dastodolistproject.Classes

import java.io.Serializable

/**
 * Created by juliannieb on 11/7/17.
 */

enum class Priority {
    HIGH, MEDIUM, LOW
}

data class DataTask(val id: Long, val title: String, val description: String, val priority: Priority,
                    val intervalTime: Long, val timeWorkedOn: Long) : Serializable

class Task {

    var id: Long = 0
    var title: String = ""
    var description: String = ""
    var priority: Priority = Priority.LOW
    var intervalTime: Long = 0
    var timeWorkedOn: Long = 0
    //TODO: add state

    constructor(id: Long, title: String, description: String, priority: Priority,
                intervalTime: Long, timeWorkedOn: Long) {
        this.id = id
        this.title = title
        this.description = description
        this.priority = priority
        this.intervalTime = intervalTime
        this.timeWorkedOn = timeWorkedOn
    }

}