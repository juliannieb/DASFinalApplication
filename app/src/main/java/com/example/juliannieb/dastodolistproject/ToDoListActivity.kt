package com.example.juliannieb.dastodolistproject

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import com.example.juliannieb.dastodolistproject.Adapters.TasksListAdapter
import com.example.juliannieb.dastodolistproject.Classes.Priority
import com.example.juliannieb.dastodolistproject.Classes.TaskFactory
import com.example.juliannieb.dastodolistproject.Classes.ToDoList

class ToDoListActivity : AppCompatActivity() {

    var listViewTasks: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do_list)
        setToolbar()
        getLayoutElements()
        setLayoutElements()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_to_do_list_activity, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            R.id.action_stop_watch -> {
                val intent = Intent(this, StopWatchActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.action_timer -> {
                val intent = Intent(this, TimerActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun setToolbar() {
        supportActionBar!!.title = resources.getString(R.string.app_name)
    }

    fun getLayoutElements() {
        listViewTasks = findViewById<ListView>(R.id.listViewTasks)
    }

    fun setLayoutElements() {
        setTasksLists()
    }

    fun setTasksLists() {
        val taskListAdapter = TasksListAdapter(this, R.layout.item_tasks_list, ToDoList.instance.tasks)
        listViewTasks!!.adapter = taskListAdapter
    }
}
