package com.example.sande.projectmanagementpersonal.priority;

import com.google.gson.annotations.SerializedName;


public class SubTaskPriorityPojo{


    @SerializedName("taskid")
    private String taskid;

    @SerializedName("subtaskid")
    private String subtaskid;

    @SerializedName("projectid")
    private String project_id;
    @SerializedName("priority")
    private String userid;

    public SubTaskPriorityPojo() {
    }

    @Override
    public String toString() {
        return "SubTaskPriorityPojo{" +
                "taskid='" + taskid + '\'' +
                ", subtaskid='" + subtaskid + '\'' +
                ", project_id='" + project_id + '\'' +
                ", userid='" + userid + '\'' +
                '}';
    }

    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid;
    }

    public String getSubtaskid() {
        return subtaskid;
    }

    public void setSubtaskid(String subtaskid) {
        this.subtaskid = subtaskid;
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

    public SubTaskPriorityPojo(String taskid, String subtaskid, String project_id, String userid) {
        this.taskid = taskid;
        this.subtaskid = subtaskid;
        this.project_id = project_id;
        this.userid = userid;
    }
}
