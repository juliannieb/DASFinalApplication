package com.example.juliannieb.dastodolistproject.Classes

import android.os.Handler

/**
 * Created by juliannieb on 11/5/17.
 */

class Timer: Watch {

    /**
     * Create a Timer object with default values.
     *
     */
    constructor() : super()

    /**
     * Create a Timer object.
     *
     * @param hour Hour of the watch
     * @param minute Minute of the watch
     * @param second Second of the watch
     */
    constructor(hour : Int, minute : Int, second : Int) : super(hour, minute, second)


    /**
     * Override the tick method. Ticks the watch once and executes a code block after that.
     *
     * @param callback code block to be executed after the ticking
     */
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