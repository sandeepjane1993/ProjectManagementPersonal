package com.example.sande.projectmanagementpersonal.pojo;

import com.google.gson.annotations.SerializedName;

public class ProjectListPOJO {

    @SerializedName("id")
    private String projectId;
    @SerializedName("projectname")
    private String projectName;
    @SerializedName("projectstatus")
    private String projectStatus;
    @SerializedName("projectdesc")
    private String projectDescription;
    @SerializedName("startdate")
    private String projStartDate;
    @SerializedName("endstart")
    private String projEndStart;

    public ProjectListPOJO(String projectId, String projectName, String projectStatus, String projectDescription, String projStartDate, String projEndStart) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectStatus = projectStatus;
        this.projectDescription = projectDescription;
        this.projStartDate = projStartDate;
        this.projEndStart = projEndStart;
    }

    @Override
    public String toString() {
        return "ProjectListPOJO{" +
                "projectId='" + projectId + '\'' +
                ", projectName='" + projectName + '\'' +
                ", projectStatus='" + projectStatus + '\'' +
                ", projectDescription='" + projectDescription + '\'' +
                ", projStartDate='" + projStartDate + '\'' +
                ", projEndStart='" + projEndStart + '\'' +
                '}';
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getProjStartDate() {
        return projStartDate;
    }

    public void setProjStartDate(String projStartDate) {
        this.projStartDate = projStartDate;
    }

    public String getProjEndStart() {
        return projEndStart;
    }

    public void setProjEndStart(String projEndStart) {
        this.projEndStart = projEndStart;
    }
}
