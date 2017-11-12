package com.example.juliannieb.dastodolistproject.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.juliannieb.dastodolistproject.Classes.Priority
import com.example.juliannieb.dastodolistproject.Classes.Task
import com.example.juliannieb.dastodolistproject.R
import kotlinx.android.synthetic.main.item_tasks_list.view.*

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

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var taskHolder: TaskHolder
        var view: View
        if (convertView == null) {
            val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = layoutInflater.inflate(resource!!, null)
            taskHolder = TaskHolder()

            taskHolder.txtViewTaskTitle = view.findViewById<TextView>(R.id.txtViewTaskTitle)
            taskHolder.txtViewTaskInterval = view.findViewById<TextView>(R.id.txtViewTaskInterval)
            taskHolder.txtViewTaskTimeWorkedOn = view.findViewById<TextView>(R.id.txtViewTaskTimeWorkedOn)
            taskHolder.txtViewTaskPriority = view.findViewById<TextView>(R.id.txtViewTaskPriority)

            view.tag = taskHolder
        }
        else {
            taskHolder = convertView.tag as TaskHolder
            view = convertView
        }

        val task = tasks!!.get(position)

        if (task.title != null) {
            taskHolder.txtViewTaskTitle!!.text = task.title
        }
        if (task.intervalTime != null) {
            taskHolder.txtViewTaskInterval!!.text = "Interval: ${task.intervalTime}"
        }
        if (task.timeWorkedOn != null) {
            taskHolder.txtViewTaskTimeWorkedOn!!.text = "Total time: ${task.timeWorkedOn}"
        }
        if (task.priority != null) {
            if (task.priority == Priority.HIGH) {
                taskHolder.txtViewTaskPriority!!.text = "HIGH"
                taskHolder.txtViewTaskPriority!!.setTextColor(context.resources.getColor(R.color.colorPriorityHigh))
            }
            else if (task.priority == Priority.MEDIUM) {
                taskHolder.txtViewTaskPriority!!.text = "MEDIUM"
                taskHolder.txtViewTaskPriority!!.setTextColor(context.resources.getColor(R.color.colorPriorityMedium))
            }
            else if (task.priority == Priority.LOW) {
                taskHolder.txtViewTaskPriority!!.text = "LOW"
                taskHolder.txtViewTaskPriority!!.setTextColor(context.resources.getColor(R.color.colorPriorityLow))
            }
        }

        return view
    }

    class TaskHolder {
        var txtViewTaskTitle: TextView? = null
        var txtViewTaskInterval: TextView? = null
        var txtViewTaskTimeWorkedOn: TextView? = null
        var txtViewTaskPriority: TextView? = null
    }

}