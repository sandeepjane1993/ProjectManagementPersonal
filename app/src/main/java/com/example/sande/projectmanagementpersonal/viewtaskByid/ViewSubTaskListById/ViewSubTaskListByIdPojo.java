package com.example.sande.projectmanagementpersonal.viewtaskByid.ViewSubTaskListById;

public class ViewSubTaskListByIdPojo {

    String projectid;

    String taskid;

    String subtaskid;

    public ViewSubTaskListByIdPojo(String projectid, String taskid, String subtaskid) {
        this.projectid = projectid;
        this.taskid = taskid;
        this.subtaskid = subtaskid;
    }

    @Override
    public String toString() {
        return "ViewTaskListByIdPojo{" +
                "projectid='" + projectid + '\'' +
                ", taskid='" + taskid + '\'' +
                ", subtaskid='" + subtaskid + '\'' +
                '}';
    }

    public String getProjectid() {
        return projectid;
    }

    public void setProjectid(String projectid) {
        this.projectid = projectid;
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
}
