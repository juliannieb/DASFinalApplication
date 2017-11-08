package com.example.juliannieb.dastodolistproject.Classes

/**
 * Created by juliannieb on 11/8/17.
 */

class TaskFactory {

    var id: Long = 0
    var title: String = ""
    var description: String = ""
    var priority: Priority = Priority.LOW
    var intervalTime: Long = 0
    var timeWorkedOn: Long = 0

    constructor() {
        this.id = 0
        this.title = ""
        this.description = ""
        this.priority = Priority.LOW
        this.intervalTime = 0
        this.timeWorkedOn = 0
    }

    fun build(): Task {
        return Task(this)
    }

    fun id(id: Long): TaskFactory {
        this.id = id
        return this
    }

    fun title(title: String): TaskFactory {
        this.title = title
        return this
    }

    fun description(description: String): TaskFactory {
        this.description = description
        return this
    }

    fun priority(priority: Priority): TaskFactory {
        this.priority = priority
        return this
    }

    fun intervalTime(intervalTime: Long): TaskFactory {
        this.intervalTime = intervalTime
        return this
    }

    fun timeWorkedOn(timeWorkedOn: Long): TaskFactory {
        this.timeWorkedOn = timeWorkedOn
        return this
    }

}