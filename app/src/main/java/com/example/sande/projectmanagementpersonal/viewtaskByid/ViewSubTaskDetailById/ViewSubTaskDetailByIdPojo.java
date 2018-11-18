package com.example.sande.projectmanagementpersonal.viewtaskByid.ViewSubTaskDetailById;
import com.google.gson.annotations.SerializedName;

public class ViewSubTaskDetailByIdPojo {
    @SerializedName("subtaskid")
    String subtaskid;
    @SerializedName("projectid")
    String projectid;
    @SerializedName("subtaskname")
    String subtaskname;
    @SerializedName("subtaskstatus")
    String subtaskstatus;
    @SerializedName("subtaskdesc")
    String subtaskdesc;
    @SerializedName("startdate")
    String startdate;
    @SerializedName("endstart")
    String endstart;
    String temp;
    @Override
    public String toString() {
        if (subtaskstatus.equals("1")){
             temp= "Start new project";

        }
        else if(subtaskstatus.equals("2")){
             temp = "Not complete";

        }
        else if(subtaskstatus.equals("3")){
             temp= "Completed";

        }

        return
                "subtaskid= " + subtaskid + '\n' +
                "projectid= " + projectid + '\n' +
                "subtaskname= " + subtaskname + '\n' +
                "subtaskstatus= " + temp + '\n' +
                "subtaskdesc= " + subtaskdesc + '\n' +
                "startdate= " + startdate + '\n' +
                "endstart= " + endstart + '\n' ;
    }

    public ViewSubTaskDetailByIdPojo(String subtaskid, String projectid, String subtaskname, String subtaskstatus, String subtaskdesc, String startdate, String endstart) {
        this.subtaskid = subtaskid;
        this.projectid = projectid;
        this.subtaskname = subtaskname;

        this.subtaskstatus = subtaskstatus;
        this.subtaskdesc = subtaskdesc;
        this.startdate = startdate;
        this.endstart = endstart;
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

    public String getSubtaskname() {
        return subtaskname;
    }

    public void setSubtaskname(String subtaskname) {
        this.subtaskname = subtaskname;
    }

    public String getSubtaskstatus() {
        return subtaskstatus;
    }

    public void setSubtaskstatus(String subtaskstatus) {
        this.subtaskstatus = subtaskstatus;
    }

    public String getSubtaskdesc() {
        return subtaskdesc;
    }

    public void setSubtaskdesc(String subtaskdesc) {
        this.subtaskdesc = subtaskdesc;
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
}
