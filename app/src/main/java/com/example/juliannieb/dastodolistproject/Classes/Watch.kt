package com.example.juliannieb.dastodolistproject.Classes

/**
 * Created by juliannieb on 11/3/17.
 */

class Watch {

    var hour : Int
        get() = this.hour
        set(hour) {
            this.hour = hour
        }

    var minute : Int
        get() = this.minute
        set(minute) {
            this.minute = minute
        }

    var second : Int
        get() = this.second
        set(second) {
            this.second = second
        }

    constructor() {
        this.hour = 0
        this.minute = 0
        this.second = 0
    }

    constructor(hour : Int, minute : Int, second : Int) {
        this.hour = hour
        this.minute = minute
        this.second = second
    }

    fun tickForwards() {
        this.second++
        if (this.second == 60) {
            this.second = 0
            this.minute++
            if (this.minute == 60) {
                this.minute = 0
                this.hour++
            }
        }
    }

    fun tickBackwards() {
        if (this.hour == 0 && this.minute == 0 && this.second == 0){
            return
        }
        this.second--
        if (this.second == 0) {
            this.second = 59
            this.minute--
            if (this.minute == 0) {
                this.minute = 59
                this.hour--
            }
        }
    }

    override fun toString(): String {
        val hourString = if (this.hour >= 10) "${this.hour}" else "0${this.hour}"
        val minuteString = if (this.minute >= 10) "${this.minute}" else "0${this.minute}"
        val secondString = if (this.second >= 10) "${this.second}" else "0${this.second}"
        return "${hourString}:${minuteString}:${secondString}"
    }

}
