package com.example.juliannieb.dastodolistproject.Classes

/**
 * Created by juliannieb on 11/3/17.
 */

open class Watch {

    var hour : Int = 0
    var minute : Int = 0
    var second : Int = 0

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

    fun setWatch(hour: Int, minute: Int, second: Int) {
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
        if (this.second == -1) {
            if (this.minute > 0 || this.hour > 0) {
                this.second = 59
            }
            if (this.minute > 0) {
                this.minute--
            }
            if (this.minute == 0) {
                if (this.hour > 0) {
                    this.minute = 59
                    this.hour--
                }
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
