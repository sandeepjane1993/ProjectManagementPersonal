package com.example.sande.projectmanagementpersonal.responses;

import com.example.sande.projectmanagementpersonal.pojo.EmployeePOJO;
import com.example.sande.projectmanagementpersonal.pojo.SubTaskListPOJO;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EmployeeListResponse {

    @SerializedName("employees")
    private List<EmployeePOJO> employeePOJOList;

    public EmployeeListResponse(List<EmployeePOJO> employeePOJOList) {
        this.employeePOJOList = employeePOJOList;
    }

    public List<EmployeePOJO> getEmployeePOJOList() {
        return employeePOJOList;
    }
}
