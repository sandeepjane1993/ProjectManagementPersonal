package com.example.sande.projectmanagementpersonal.pojo;

import com.google.gson.annotations.SerializedName;

public class TaskListPOJO {

    @SerializedName("taskid")
    private String taskId;
    @SerializedName("projectid")
    private String projectId;
    @SerializedName("taskname")
    private String taskName;
    @SerializedName("taskstatus")
    private String taskStatus;
    @SerializedName("taskdesc")
    private String taskDescription;
    @SerializedName("startdate")
    private String startDate;
    @SerializedName("endstart")
    private String endDate;

    public TaskListPOJO(String taskId, String projectId, String taskName, String taskStatus, String taskDescription, String startDate, String endDate) {
        this.taskId = taskId;
        this.projectId = projectId;
        this.taskName = taskName;
        this.taskStatus = taskStatus;
        this.taskDescription = taskDescription;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "TaskListPOJO{" +
                "taskId='" + taskId + '\'' +
                ", projectId='" + projectId + '\'' +
                ", taskName='" + taskName + '\'' +
                ", taskStatus='" + taskStatus + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
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

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
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
