package com.example.juliannieb.dastodolistproject.Classes

import android.content.Context
import com.example.juliannieb.dastodolistproject.Classes.StrategiesToDoList.StrategyPriority
import com.example.juliannieb.dastodolistproject.Classes.StrategiesToDoList.StrategyToDoList
import org.json.JSONArray
import org.json.JSONObject
import java.io.Serializable
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by juliannieb on 11/7/17.
 */

class ToDoList {

    var tasks: ArrayList<Task> = ArrayList<Task>()
    var draft: DataTask? = null
    var strategyToDoList: StrategyToDoList = StrategyPriority()
    var currId: Long = 0

    /**
     * Create a ToDoList object with default values
     *
     */
    private constructor() {

    }

    /**
     * Holder that contains the instace of a ToDoList singleton object.
     *
     */
    private object Holder {val INSTANCE = ToDoList()}

    /**
     * Declares a 'static' property called instance for the class.
     *
     */
    companion object {
        val instance: ToDoList by lazy { Holder.INSTANCE }
    }

    /**
     * Add a task to the tasks list.
     *
     * @param task Task to be added
     */
    fun addTask(task: Task) {
        this.tasks.add(task)
    }

    /**
     * Sort the tasks list according to the selected strategy.
     *
     */
    fun sortTasks() {
        this.strategyToDoList.sortTasks()
    }

    /**
     * Get the index of a task in the list.
     *
     * @param task Task to look for
     */
    fun getTaskIdx(task: Task): Int {
        for(i in tasks.indices) {
            val currTask = tasks.get(i)
            if (currTask.id == task.id) {
                return i
            }
        }
        return -1
    }

    /**
     * Stores all the ToDoList important data in the shared preferences.
     *
     * @param context Context for saving
     */
    fun save(context: Context) {
        val preferences = context.getSharedPreferences("tasks", 0)
        val editor = preferences.edit()
        val dataTasksJSON = JSONArray()
        for(i in tasks.indices) {
            val taskJSON = tasks.get(i).toJSONObject()
            dataTasksJSON.put(taskJSON)
        }
        editor.putString("tasks", dataTasksJSON.toString())
        editor.putLong("currId", currId)
        editor.apply()
    }

    /**
     * Load stored data of a previous session of the ToDoList.
     *
     * @param context Context to load data
     */
    fun load(context: Context) {
        val preferences = context.getSharedPreferences("tasks", 0)
        var dataTasksString = preferences.getString("tasks", JSONArray().toString())
        val dataTasksJSON = JSONArray(dataTasksString)
        for (i in 0..(dataTasksJSON.length() - 1)) {
            val taskJSONObject = dataTasksJSON.get(i) as JSONObject
            val task = Task(taskJSONObject)
            tasks.add(task)
        }
        sortTasks()
        currId = preferences.getLong("currId", 0)
    }

}