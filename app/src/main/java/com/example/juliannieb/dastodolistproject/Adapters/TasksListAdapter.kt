package com.example.juliannieb.dastodolistproject.Adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import com.example.juliannieb.dastodolistproject.Classes.Task

/**
 * Created by juliannieb on 11/8/17.
 */

class TasksListAdapter: ArrayAdapter<Task> {

    var resource: Int? = null
    var tasks: List<Task>? = null


    constructor(context: Context, resource: Int, tasks: List<Task>): super(context, resource, tasks) {
        this.resource = resource
        this.tasks = tasks
    }

    override fun getItem(p0: Int): Task {
        return this.tasks!!.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return this.tasks!!.size
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}