package com.example.sande.projectmanagementpersonal.team

import android.content.Context
import android.databinding.BaseObservable
import com.example.sande.projectmanagementpersonal.pojo.EmployeePOJO

class EmployeeViewModel(val generalEmployeeFragment : EmployeeInterface, context: Context?) : BaseObservable() {

    var employeeRepository : EmployeeRepository =
        EmployeeRepository(context, this)

    fun initEmployeeList() {

        employeeRepository.initEmployeeList()

    }

    fun getEmployeeList(employeeList: List<EmployeePOJO>) {
        generalEmployeeFragment.getEmployeeList(employeeList)
    }

    fun addEmployee(employeeId: String, projectId: String?) {
        employeeRepository.addEmployee(employeeId, projectId)
    }

    fun showAddEmployeeInfo(info: String) {
        generalEmployeeFragment.showAddEmployeeInfo(info)
    }


}