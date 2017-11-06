package com.example.juliannieb.dastodolistproject.Classes

import android.os.Handler

/**
 * Created by juliannieb on 11/5/17.
 */

class Timer: Watch {

    var ticking: Boolean = false

    constructor() : super() {
        this.ticking = false
    }

    constructor(hour : Int, minute : Int, second : Int) : super(hour, minute, second) {
        this.ticking = false
    }

    fun <T> start(callback: () -> T) {
        this.ticking = true
        tick(callback)
    }

    fun <T> tick(callback: () -> T) {
        if (this.hour == 0 && this.minute == 0 && this.second == 0) {
            stop()
        }
        if (this.ticking) {
            callback()
            this.tickBackwards()
            val handler = Handler()
            handler.postDelayed(Runnable {
                this.tick(callback)
            }, 1000)
        }
    }

    fun stop() {
        this.ticking = false
    }
}