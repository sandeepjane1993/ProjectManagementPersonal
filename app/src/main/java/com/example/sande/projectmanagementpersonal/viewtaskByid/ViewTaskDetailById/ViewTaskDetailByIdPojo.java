package com.example.sande.projectmanagementpersonal.viewtaskByid.ViewTaskDetailById;

import com.google.gson.annotations.SerializedName;

public class ViewTaskDetailByIdPojo {
    @SerializedName("taskid")
    String taskid;
    @SerializedName("projectid")
    String projectid;
    @SerializedName("taskname")
    String taskname;
    @SerializedName("taskstatus")
    String taskstatus;
    @SerializedName("taskdesc")
    String taskdesc;
    @SerializedName("startdate")
    String startdate;
    @SerializedName("endstart")
    String endstart;

    @Override
    public String toString() {
        return
                "taskid= " + taskid + '\n' +
                "projectid= " + projectid + '\n' +
                "taskname= " + taskname + '\n' +
                "taskstatus= " + taskstatus + '\n' +
                "taskdesc= " + taskdesc + '\n' +
                "startdate= " + startdate + '\n' +
                "endstart= " + endstart + '\n' ;
    }

    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid;
    }

    public String getProjectid() {
        return projectid;
    }

    public void setProjectid(String projectid) {
        this.projectid = projectid;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public String getTaskstatus() {
        return taskstatus;
    }

    public void setTaskstatus(String taskstatus) {
        this.taskstatus = taskstatus;
    }

    public String getTaskdesc() {
        return taskdesc;
    }

    public void setTaskdesc(String taskdesc) {
        this.taskdesc = taskdesc;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEndstart() {
        return endstart;
    }

    public void setEndstart(String endstart) {
        this.endstart = endstart;
    }

    public ViewTaskDetailByIdPojo(String taskid, String projectid, String taskname, String taskstatus, String taskdesc, String startdate, String endstart) {
        this.taskid = taskid;
        this.projectid = projectid;
        this.taskname = taskname;
        this.taskstatus = taskstatus;
        this.taskdesc = taskdesc;
        this.startdate = startdate;
        this.endstart = endstart;
    }
}
