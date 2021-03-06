package com.example.sande.projectmanagementpersonal.team

import android.content.Context
import android.databinding.BaseObservable
import com.example.sande.projectmanagementpersonal.pojo.EmployeePOJO
import com.example.sande.projectmanagementpersonal.pojo.MemberOfSubtaskPOJO

class EmployeeViewModel(val generalEmployeeFragment : EmployeeInterface, context: Context?) : BaseObservable() {

    var employeeRepository : EmployeeRepository =
        EmployeeRepository(context, this)

    fun initEmployeeList() {

        employeeRepository.initEmployeeList()

    }

    fun getEmployeeList(employeeList: List<EmployeePOJO>) {
        generalEmployeeFragment.getEmployeeList(employeeList)
    }

    fun addEmployee(projectId: String, employeeId: String, taskId: String, subTaskId: String) {
        employeeRepository.addEmployee(projectId, employeeId, taskId, subTaskId)
    }

    fun showAddEmployeeInfo(info: String) {
        generalEmployeeFragment.showAddEmployeeInfo(info)
    }

    fun getEmployeeListBySubtask() {
        employeeRepository.getEmployeeListBySubtask()
    }

    fun showMemberOfSubtask(memberOfSubtaskList: List<MemberOfSubtaskPOJO>) {
        generalEmployeeFragment.showMemberOfSubtask(memberOfSubtaskList)
    }


}