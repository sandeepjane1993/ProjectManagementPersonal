package com.example.sande.projectmanagementpersonal.viewtaskByid.ViewTeamMenberByTask;



public class TeamMenberListByTaskPojo {

    String assignid;

    String taskid;

    String projectid;

    String userid;

    @Override
    public String toString() {
        return "TeamMenberListByTask" +"\n"+
                "assignid= " + assignid + '\n' +
                ", taskid= " + taskid + '\n' +
                ", projectid= " + projectid + '\n' +
                ", userid= " + userid + '\n' +
                '}';
    }

    public TeamMenberListByTaskPojo(String assignid, String taskid, String projectid, String userid) {
        this.assignid = assignid;
        this.taskid = taskid;
        this.projectid = projectid;
        this.userid = userid;
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