package com.example.sande.projectmanagementpersonal.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UpdateSubtaskResponse {

    @SerializedName("msg")
    List<String> message;

    public UpdateSubtaskResponse(List<String> message) {
        this.message = message;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }
}
