package com.example.juliannieb.dastodolistproject.Classes

import android.os.Handler

/**
 * Created by juliannieb on 11/5/17.
 */

class Timer: Watch {

    constructor() : super()

    constructor(hour : Int, minute : Int, second : Int) : super(hour, minute, second)


    override fun <T> tick(callback: () -> T) {
        if (this.hour == 0 && this.minute == 0 && this.second == 0) {
            stop(callback)
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

}