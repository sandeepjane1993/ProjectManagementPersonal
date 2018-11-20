package com.example.sande.projectmanagementpersonal.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CreateTeamResponse {

    @SerializedName("msg")
    List<String> message;

    public CreateTeamResponse(List<String> message) {
        this.message = message;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "CreateTeamResponse{" +
                "message=" + message +
                '}';
    }
}
