package com.example.sande.projectmanagementpersonal.pojo;

import com.google.gson.annotations.SerializedName;

public class MemberOfSubtaskPOJO {

    @SerializedName("assignid")
    String assignid;
    @SerializedName("taskid")
    String taskid;
    @SerializedName("subtaskid")
    String subtaskid;
    @SerializedName("projectid")
    String projectid;
    @SerializedName("userid")
    String userid;

    public MemberOfSubtaskPOJO(String assignid, String taskid, String subtaskid, String projectid, String userid) {
        this.assignid = assignid;
        this.taskid = taskid;
        this.subtaskid = subtaskid;
        this.projectid = projectid;
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "MemberOfSubtaskPOJO{" +
                "assignid='" + assignid + '\'' +
                ", taskid='" + taskid + '\'' +
                ", subtaskid='" + subtaskid + '\'' +
                ", projectid='" + projectid + '\'' +
                ", userid='" + userid + '\'' +
                '}';
    }

    public String getAssignid() {
        return assignid;
    }

    public void setAssignid(String assignid) {
        this.assignid = assignid;
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

    public String getProjectid() {
        return projectid;
    }

    public void setProjectid(String projectid) {
        this.projectid = projectid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
