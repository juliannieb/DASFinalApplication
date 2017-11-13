package com.example.juliannieb.dastodolistproject.Classes

import org.json.JSONObject
import java.io.Serializable

/**
 * Created by juliannieb on 11/7/17.
 */

enum class Priority() {
    HIGH, MEDIUM, LOW, COMPLETED
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

    constructor() {
        id = 0
        title = ""
        description = ""
        priority = Priority.LOW
        intervalTime = 0
        timeWorkedOn = 0
    }

    constructor(id: Long, title: String, description: String, priority: Priority,
                intervalTime: Long, timeWorkedOn: Long) {
        this.id = id
        this.title = title
        this.description = description
        this.priority = priority
        this.intervalTime = intervalTime
        this.timeWorkedOn = timeWorkedOn
    }

    constructor(taskFactory: TaskFactory) {
        this.id = taskFactory.id
        this.title = taskFactory.title
        this.description = taskFactory.description
        this.priority = taskFactory.priority
        this.intervalTime = taskFactory.intervalTime
        this.timeWorkedOn = taskFactory.timeWorkedOn
    }

    constructor(dataTask: DataTask) {
        this.id = dataTask.id
        this.title = dataTask.title
        this.description = dataTask.description
        this.priority = dataTask.priority
        this.intervalTime = dataTask.intervalTime
        this.timeWorkedOn = dataTask.timeWorkedOn
    }

    constructor(jsonObject: JSONObject) {
        if (jsonObject.getLong("id") != null) {
            this.id = jsonObject.getLong("id")
        }
        if (jsonObject.getString("title") != null) {
            this.title = jsonObject.getString("title")
        }
        if (jsonObject.getString("description") != null) {
            this.description = jsonObject.getString("description")
        }
        if (jsonObject.getInt("priority") != null) {
            val priority = jsonObject.getInt("priority")
            if (priority == Priority.COMPLETED.ordinal) {
                this.priority = Priority.COMPLETED
            }
            else if (priority == Priority.LOW.ordinal) {
                this.priority = Priority.LOW
            }
            else if (priority == Priority.MEDIUM.ordinal) {
                this.priority = Priority.MEDIUM
            }
            else if (priority == Priority.HIGH.ordinal) {
                this.priority = Priority.HIGH
            }
        }
        if (jsonObject.getLong("intervalTime") != null) {
            this.intervalTime = jsonObject.getLong("intervalTime")
        }
        if (jsonObject.getLong("timeWorkedOn") != null) {
            this.timeWorkedOn = jsonObject.getLong("timeWorkedOn")
        }
    }

    fun saveMemento(): DataTask {
        return DataTask(this.id, this.title, this.description, this.priority, this.intervalTime, this.timeWorkedOn)
    }

    fun restoreFromMemento(dataTask: DataTask) {
        this.id = dataTask.id
        this.title = dataTask.title
        this.description = dataTask.description
        this.priority = dataTask.priority
        this.intervalTime = dataTask.intervalTime
        this.timeWorkedOn = dataTask.timeWorkedOn
    }

    fun toJSONObject(): JSONObject {
        val jsonObject = JSONObject()
        jsonObject.put("id", id)
        jsonObject.put("title", title)
        jsonObject.put("description", description)
        jsonObject.put("priority", priority.ordinal)
        jsonObject.put("intervalTime", intervalTime)
        jsonObject.put("timeWorkedOn", timeWorkedOn)
        return jsonObject
    }

    override fun toString(): String {
        return "${this.id} - ${this.title} - ${this.priority}"
    }

}