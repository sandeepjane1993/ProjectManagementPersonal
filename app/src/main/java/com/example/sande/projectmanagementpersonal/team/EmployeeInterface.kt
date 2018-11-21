package com.example.sande.projectmanagementpersonal.team

import com.example.sande.projectmanagementpersonal.pojo.EmployeePOJO
import com.example.sande.projectmanagementpersonal.pojo.MemberOfSubtaskPOJO

interface EmployeeInterface {
    fun getEmployeeList(employeeList: List<EmployeePOJO>)

    fun showAddEmployeeInfo(info: String)

    fun showMemberOfSubtask(memberOfSubtaskList: List<MemberOfSubtaskPOJO>)
}