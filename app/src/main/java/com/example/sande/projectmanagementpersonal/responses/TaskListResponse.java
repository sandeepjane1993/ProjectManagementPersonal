package com.example.sande.projectmanagementpersonal.responses;

import com.example.sande.projectmanagementpersonal.pojo.TaskListPOJO;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TaskListResponse {


    @SerializedName("project task")
    private List<TaskListPOJO> taskListResponse;

    public TaskListResponse(List<TaskListPOJO> taskListResponse) {
        this.taskListResponse = taskListResponse;
    }

    public List<TaskListPOJO> getTaskListResponse() {
        return taskListResponse;
    }
}
