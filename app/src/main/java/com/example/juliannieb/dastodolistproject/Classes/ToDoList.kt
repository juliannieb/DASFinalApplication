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

    private constructor() {

    }

    private object Holder {val INSTANCE = ToDoList()}

    companion object {
        val instance: ToDoList by lazy { Holder.INSTANCE }
    }

    fun addTask(task: Task) {
        this.tasks.add(task)
    }

    fun sortTasks() {
        this.strategyToDoList.sortTasks()
    }

    fun getTaskIdx(task: Task): Int {
        for(i in tasks.indices) {
            val currTask = tasks.get(i)
            if (currTask.id == task.id) {
                return i
            }
        }
        return -1
    }

    fun save(context: Context) {
        val preferences = context.getSharedPreferences("tasks", 0)
        val editor = preferences.edit()
        val dataTasksJSON = JSONArray()
        for(i in tasks.indices) {
            val taskJSON = tasks.get(i).toJSONObject()
            dataTasksJSON.put(taskJSON)
        }
        editor.putString("tasks", dataTasksJSON.toString())
        editor.apply()
    }

    fun load(context: Context) {
        val preferences = context.getSharedPreferences("tasks", 0)
        var dataTasksString = preferences.getString("tasks", JSONArray().toString())
        val dataTasksJSON = JSONArray(dataTasksString)
        for (i in 0..(dataTasksJSON.length() - 1)) {
            val taskJSONObject = dataTasksJSON.get(i) as JSONObject
            val task = Task(taskJSONObject)
            tasks.add(task)
        }
    }

}