package com.example.sande.projectmanagementpersonal.priority

import android.content.Context
import android.databinding.BaseObservable



class SubTaskPriorityViewModel(val fragment : SubTaskPriority, context: Context?) : BaseObservable() {

    var employeeDetailRepository : SubTaskPriorityRepository =
            SubTaskPriorityRepository(context, this)

    fun callwebwservice(A:String,B:String,C:String,D:String) {

        employeeDetailRepository.callwebwservice(A,B,C,D)

    }



    fun showePriority(response: SubTaskPriorityPojo) {
        fragment.showePriority(response);
    }


}
