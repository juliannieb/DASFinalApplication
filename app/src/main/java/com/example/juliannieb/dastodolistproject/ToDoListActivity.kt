package com.example.juliannieb.dastodolistproject

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import android.widget.RadioGroup
import com.example.juliannieb.dastodolistproject.Adapters.TasksListAdapter
import com.example.juliannieb.dastodolistproject.Classes.StrategiesToDoList.StrategyAlphabetically
import com.example.juliannieb.dastodolistproject.Classes.StrategiesToDoList.StrategyPriority
import com.example.juliannieb.dastodolistproject.Classes.StrategiesToDoList.StrategyTotalTime
import com.example.juliannieb.dastodolistproject.Classes.ToDoList

class ToDoListActivity : AppCompatActivity() {

    var radioGroupSort: RadioGroup? = null
    var listViewTasks: ListView? = null

    /**
     * Overrides method when the activity is created.
     *
     * @param savedInstanceState the saved bundle
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do_list)
        ToDoList.instance.load(this)
        setToolbar()
        getLayoutElements()
        setLayoutElements()
    }

    /**
     * Overrides method when the activity is resumed.
     *
     */
    override fun onResume() {
        super.onResume()
        setTasksLists()
    }

    /**
     * Overrides method to create the menu of the activity.
     *
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_to_do_list_activity, menu)
        return true
    }

    /**
     * Overrides method when an option of the menu is selected.
     *
     * @param item the selected item of the menu
     */
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            R.id.action_add_task -> {
                val intent = Intent(this, TaskActivity::class.java)
                intent.putExtra("StateTaskActivity", Utils.StateTaskActivity.STATE_CREATE.ordinal)
                intent.putExtra("task", ToDoList.instance.draft)
                startActivity(intent)
                return true
            }
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

    /**
     * Set properties of the toolbar.
     *
     */
    fun setToolbar() {
        supportActionBar!!.title = resources.getString(R.string.app_name)
    }

    /**
     * Get GUI elements from the layout.
     *
     */
    fun getLayoutElements() {
        radioGroupSort = findViewById<RadioGroup>(R.id.radioGroupSort)
        listViewTasks = findViewById<ListView>(R.id.listViewTasks)
    }

    /**
     * Set properties of the GUI elements.
     *
     */
    fun setLayoutElements() {
        radioGroupSort!!.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { radioGroup, i ->
            if (i == R.id.btnPriority) {
                ToDoList.instance.strategyToDoList = StrategyPriority()
                ToDoList.instance.sortTasks()
                setTasksLists()
            }
            else if (i == R.id.btnAlphabetical) {
                ToDoList.instance.strategyToDoList = StrategyAlphabetically()
                ToDoList.instance.sortTasks()
                setTasksLists()
            }
            if (i == R.id.btnTotalTime) {
                ToDoList.instance.strategyToDoList = StrategyTotalTime()
                ToDoList.instance.sortTasks()
                setTasksLists()
            }
        })
        setTasksLists()
    }

    /**
     * Set the adapter for the listViewTasks ListView and its listeners.
     *
     */
    fun setTasksLists() {
        val taskListAdapter = TasksListAdapter(this, R.layout.item_tasks_list, ToDoList.instance.tasks)
        listViewTasks!!.adapter = taskListAdapter

        listViewTasks!!.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, TaskActivity::class.java)
            intent.putExtra("StateTaskActivity", Utils.StateTaskActivity.STATE_EDIT.ordinal)
            val task = ToDoList.instance.tasks.get(position)
            intent.putExtra("task", task.saveMemento())
            startActivity(intent)
        }
    }
}
