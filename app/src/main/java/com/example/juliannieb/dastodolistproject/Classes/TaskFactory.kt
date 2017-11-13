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

    /**
     * Create a TaskFactory object with default values.
     *
     */
    constructor() {
        this.id = 0
        this.title = ""
        this.description = ""
        this.priority = Priority.LOW
        this.intervalTime = 0
        this.timeWorkedOn = 0
    }

    /**
     * Creates a Task object using the current Factory.
     *
     */
    fun build(): Task {
        return Task(this)
    }

    /**
     * Set the task factory id.
     *
     * @param id id of the TaskFactory
     */
    fun id(id: Long): TaskFactory {
        this.id = id
        return this
    }

    /**
     * Set the task factory title.
     *
     * @param title title of the TaskFactory
     */
    fun title(title: String): TaskFactory {
        this.title = title
        return this
    }

    /**
     * Set the task factory description.
     *
     * @param description description of the TaskFactory
     */
    fun description(description: String): TaskFactory {
        this.description = description
        return this
    }

    /**
     * Set the task factory priority.
     *
     * @param priority priority of the TaskFactory
     */
    fun priority(priority: Priority): TaskFactory {
        this.priority = priority
        return this
    }

    /**
     * Set the task factory intervalTime.
     *
     * @param intervalTime intervalTime of the TaskFactory
     */
    fun intervalTime(intervalTime: Long): TaskFactory {
        this.intervalTime = intervalTime
        return this
    }

    /**
     * Set the task factory timeWorkedOn.
     *
     * @param timeWorkedOn timeWorkedOn of the TaskFactory
     */
    fun timeWorkedOn(timeWorkedOn: Long): TaskFactory {
        this.timeWorkedOn = timeWorkedOn
        return this
    }

}