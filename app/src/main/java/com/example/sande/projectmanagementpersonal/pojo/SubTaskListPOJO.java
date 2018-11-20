package com.example.sande.projectmanagementpersonal.pojo;

import com.google.gson.annotations.SerializedName;

public class SubTaskListPOJO {

    @SerializedName("subtaskid")
    private String subtaskId;
    @SerializedName("taskid")
    private String taskId;
    @SerializedName("projectid")
    private String projectId;
    @SerializedName("subtaskname")
    private String subtaskName;
    @SerializedName("subtaskstatus")
    private String subtaskStatus;
    @SerializedName("subtaskdesc")
    private String subtaskDescription;
    @SerializedName("startdate")
    private String startDate;
    @SerializedName("endstart")
    private String endDate;

    public SubTaskListPOJO(String subtaskId, String taskId, String projectId,
                           String subtaskName, String subtaskStatus, String subtaskDescription,
                           String startDate, String endDate) {
        this.subtaskId = subtaskId;
        this.taskId = taskId;
        this.projectId = projectId;
        this.subtaskName = subtaskName;
        this.subtaskStatus = subtaskStatus;
        this.subtaskDescription = subtaskDescription;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "SubTaskListPOJO{" +
                "subtaskId='" + subtaskId + '\'' +
                ", taskId='" + taskId + '\'' +
                ", projectId='" + projectId + '\'' +
                ", subtaskName='" + subtaskName + '\'' +
                ", subtaskStatus='" + subtaskStatus + '\'' +
                ", subtaskDescription='" + subtaskDescription + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }

    public String getSubtaskId() {
        return subtaskId;
    }

    public void setSubtaskId(String subtaskId) {
        this.subtaskId = subtaskId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getSubtaskName() {
        return subtaskName;
    }

    public void setSubtaskName(String subtaskName) {
        this.subtaskName = subtaskName;
    }

    public String getSubtaskStatus() {
        return subtaskStatus;
    }

    public void setSubtaskStatus(String subtaskStatus) {
        this.subtaskStatus = subtaskStatus;
    }

    public String getSubtaskDescription() {
        return subtaskDescription;
    }

    public void setSubtaskDescription(String subtaskDescription) {
        this.subtaskDescription = subtaskDescription;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
