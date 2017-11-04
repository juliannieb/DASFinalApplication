package com.example.juliannieb.dastodolistproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu

class ToDoListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do_list)
        setToolbar()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_to_do_list_activity, menu)
        return true
    }

    fun setToolbar() {
        supportActionBar!!.title = resources.getString(R.string.app_name)
    }
}
