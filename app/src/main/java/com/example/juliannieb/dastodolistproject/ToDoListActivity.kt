package com.example.juliannieb.dastodolistproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.example.juliannieb.dastodolistproject.Classes.Watch

class ToDoListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do_list)
        setToolbar()
        val watch = Watch(0, 59, 0)
        println(watch)
        watch.tickForwards()
        println(watch)
        watch.tickForwards()
        println(watch)
        watch.tickBackwards()
        println(watch)
        watch.tickBackwards()
        println(watch)
        watch.tickBackwards()
        println(watch)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_to_do_list_activity, menu)
        return true
    }

    fun setToolbar() {
        supportActionBar!!.title = resources.getString(R.string.app_name)
    }
}
