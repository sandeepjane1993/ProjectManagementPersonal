package com.example.sande.projectmanagementpersonal.tasks

import android.content.Context
import android.databinding.BaseObservable

class TaskViewModel(context: Context?) : BaseObservable() {

    var taskRepository : TaskRepository = TaskRepository(context, this)

    fun updateTask() {

    }

}