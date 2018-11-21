package com.example.sande.projectmanagementpersonal.priority;

import com.google.gson.annotations.SerializedName;

public class TaskPriorityPojo{


    @SerializedName("taskid")
    private String taskid;
    @SerializedName("projectid")
    private String project_id;
    @SerializedName("priority")
    private String userid;

    public TaskPriorityPojo() {
    }

    @Override
    public String toString() {
        return "TaskPriorityPojo{" +
                "taskid='" + taskid + '\'' +
                ", project_id='" + project_id + '\'' +
                ", userid='" + userid + '\'' +
                '}';
    }

    public TaskPriorityPojo(String taskid, String project_id, String userid) {
        this.taskid = taskid;
        this.project_id = project_id;
        this.userid = userid;
    }

    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid;
    }

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
