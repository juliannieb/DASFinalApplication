package com.example.juliannieb.dastodolistproject.Classes

import android.os.Handler

/**
 * Created by juliannieb on 11/6/17.
 */

class StopWatch: Watch {

    constructor() : super()

    constructor(hour : Int, minute : Int, second : Int) : super(hour, minute, second)


    override fun <T> tick(callback: () -> T) {
        callback()
        if (this.ticking) {
            this.tickForwards()
            val handler = Handler()
            handler.postDelayed(Runnable {
                this.tick(callback)
            }, 1000)
        }
    }
}