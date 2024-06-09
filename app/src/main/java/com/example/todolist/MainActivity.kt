package com.example.todolist

import Task
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), TaskAdapter.OnTaskClickListener {

    private lateinit var editTextTask: EditText
    private lateinit var buttonAdd: Button
    private lateinit var recyclerViewTasks: RecyclerView
    private lateinit var taskAdapter: TaskAdapter
    private val tasks = mutableListOf<Task>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextTask = findViewById(R.id.editTextTask)
        buttonAdd = findViewById(R.id.buttonAdd)
        recyclerViewTasks = findViewById(R.id.recyclerViewTasks)
        taskAdapter = TaskAdapter(tasks, this)

        recyclerViewTasks.adapter = taskAdapter
        recyclerViewTasks.layoutManager = LinearLayoutManager(this)

        buttonAdd.setOnClickListener {
            val taskName = editTextTask.text.toString().trim()
            if (taskName.isNotEmpty()) {
                val task = Task(taskName)
                tasks.add(task)
                taskAdapter.notifyItemInserted(tasks.size - 1)
                editTextTask.text.clear()
            }
        }
    }

    override fun onEditTaskClick(task: Task) {
        // Handle editing task
        // Open a dialog or activity for editing the task
    }

    override fun onDeleteTaskClick(task: Task) {
        // Handle deleting task
        tasks.remove(task)
        taskAdapter.notifyDataSetChanged()
    }
}
