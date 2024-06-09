package com.example.todolist

import Task
import android.app.Dialog
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class EditTaskDialogFragment(
    private val task: Task,
    private val onTaskUpdated: (String) -> Unit
) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        val input = EditText(requireContext())
        input.setText(task.name)

        builder.setView(input)
            .setTitle("Edit Task")
            .setPositiveButton("Save") { _, _ ->
                val newTaskName = input.text.toString().trim()
                if (newTaskName.isNotEmpty()) {
                    onTaskUpdated(newTaskName)
                }
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.cancel()
            }

        return builder.create()
    }
}
