package com.example.sande.projectmanagementpersonal.responses;

import com.example.sande.projectmanagementpersonal.pojo.ProjectListPOJO;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProjectListResponse {

    @SerializedName("projects")
    private List<ProjectListPOJO> projectListResponse;

    public ProjectListResponse(List<ProjectListPOJO> projectListResponse) {
        this.projectListResponse = projectListResponse;
    }

    public List<ProjectListPOJO> getProjectListResponse() {
        return projectListResponse;
    }

    public void setProjectListResponse(List<ProjectListPOJO> projectListResponse) {
        this.projectListResponse = projectListResponse;
    }
}
