package com.example.sande.projectmanagementpersonal.team

import com.example.sande.projectmanagementpersonal.pojo.EmployeePOJO

interface EmployeeInterface {
    fun getEmployeeList(employeeList: List<EmployeePOJO>)

    fun showAddEmployeeInfo(info: String)
}