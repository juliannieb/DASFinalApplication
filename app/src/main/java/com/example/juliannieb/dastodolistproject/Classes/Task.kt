package com.example.juliannieb.dastodolistproject.Classes

/**
 * Created by juliannieb on 11/7/17.
 */

enum class Priority {
    HIGH, MEDIUM, LOW
}

class Task {

    var id: Long = 0
    var title: String = ""
    var description: String = ""
    var priority: Priority = Priority.LOW
    var intervalTime: Long = 0
    var timeWorkedOn: Long = 0
    //TODO: add state

}