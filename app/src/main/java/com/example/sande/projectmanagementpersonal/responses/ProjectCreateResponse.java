package com.example.sande.projectmanagementpersonal.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProjectCreateResponse {

    @SerializedName("msg")
    private List<String> projectCreateResponse;

    public ProjectCreateResponse(List<String> projectCreateResponse) {
        this.projectCreateResponse = projectCreateResponse;
    }

    public List<String> getProjectCreateResponse() {
        return projectCreateResponse;
    }

    public void setProjectCreateResponse(List<String> projectCreateResponse) {
        this.projectCreateResponse = projectCreateResponse;
    }
}
