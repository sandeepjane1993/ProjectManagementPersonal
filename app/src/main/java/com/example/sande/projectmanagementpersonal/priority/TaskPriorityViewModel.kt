package com.example.sande.projectmanagementpersonal.priority

import android.content.Context
import android.databinding.BaseObservable
import android.databinding.Bindable


class TaskPriorityViewModel(val fragment : TaskPriority, context: Context?) : BaseObservable() {
    lateinit var pojo: TaskPriorityPojo

    fun TaskPriorityViewModel() {


        this.pojo = TaskPriorityPojo()
    }

    var employeeDetailRepository : TaskPriorityRepository =
            TaskPriorityRepository(context, this)

    fun callwebwservice(A:String,B:String,C:String) {

        employeeDetailRepository.callwebwservice(A,B,C)

    }

    fun showePriority(response: TaskPriorityPojo) {
        fragment.showePriority(response);
    }


    @Bindable
    fun getTaskid(): String {
        return pojo.taskid
    }

    fun setTaskid(taskid: String) {
        pojo.taskid=taskid
        //notifyPropertyChanged(BR.userDetails)
    }
    @Bindable
    fun getProjectid(): String {
        return pojo.project_id
    }

    fun setProjectid(projectid: String) {
        pojo.project_id=projectid
      //  notifyPropertyChanged(BR.userDetails)
    }


}