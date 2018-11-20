package com.example.sande.projectmanagementpersonal.viewtaskByid.ViewTeamMenberByTask

import android.content.Context
import android.databinding.BaseObservable
import com.example.sande.projectmanagementpersonal.pojo.EmployeePOJO

class EmployeeDetailViewModel(val generalEmployeeFragment : EmployeedetailInterface, context: Context?) : BaseObservable() {

    var employeeDetailRepository : EmployeeDetailRepository =
            EmployeeDetailRepository(context, this)

    fun initEmployeeList(value: String) {

        employeeDetailRepository.initEmployeeList(value)

    }



    fun showemployeedetail(response: EmployeeDetailPOJO) {
        generalEmployeeFragment.showresult(response);
    }


}