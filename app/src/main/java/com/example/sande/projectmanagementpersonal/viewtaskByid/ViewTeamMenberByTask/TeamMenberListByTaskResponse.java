package com.example.sande.projectmanagementpersonal.viewtaskByid.ViewTeamMenberByTask;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TeamMenberListByTaskResponse {

    @SerializedName("members")
    private List<TeamMenberListByTaskPojo> teamMenberListByTaskPojos;

    public TeamMenberListByTaskResponse(List<TeamMenberListByTaskPojo> teamMenberListByTaskPojos) {
        this.teamMenberListByTaskPojos = teamMenberListByTaskPojos;
    }

    public List<TeamMenberListByTaskPojo> getTeamMenberListByTaskPojos() {
        return teamMenberListByTaskPojos;
    }

    public void setTeamMenberListByTaskPojos(List<TeamMenberListByTaskPojo> teamMenberListByTaskPojos) {
        this.teamMenberListByTaskPojos = teamMenberListByTaskPojos;
    }

    @Override
    public String toString() {
        return "TenantResponse{" +
                "teamMenberListByTaskPojos=" + teamMenberListByTaskPojos +
                '}';
    }
}
