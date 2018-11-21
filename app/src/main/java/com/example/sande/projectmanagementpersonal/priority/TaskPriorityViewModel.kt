package com.example.sande.projectmanagementpersonal.priority

import android.content.Context
import android.databinding.BaseObservable


class TaskPriorityViewModel(val fragment : TaskPriority, context: Context?) : BaseObservable() {

    var employeeDetailRepository : TaskPriorityRepository =
            TaskPriorityRepository(context, this)

    fun callwebwservice(A:String,B:String,C:String) {

        employeeDetailRepository.callwebwservice(A,B,C)

    }



    fun showePriority(response: TaskPriorityPojo) {
        fragment.showePriority(response);
    }


}