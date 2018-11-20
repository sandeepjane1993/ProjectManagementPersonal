package com.example.sande.projectmanagementpersonal.responses;

import com.example.sande.projectmanagementpersonal.pojo.SubTaskListPOJO;
import com.example.sande.projectmanagementpersonal.pojo.TaskListPOJO;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SubTaskListResponse {

    @SerializedName("project sub task")
    private List<SubTaskListPOJO> subTaskListResponses;

    public SubTaskListResponse(List<SubTaskListPOJO> subTaskListResponses) {
        this.subTaskListResponses = subTaskListResponses;
    }

    public List<SubTaskListPOJO> getSubTaskListResponse() {
        return subTaskListResponses;
    }
}
