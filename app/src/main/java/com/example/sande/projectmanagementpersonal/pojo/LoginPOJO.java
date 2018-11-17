package com.example.sande.projectmanagementpersonal.pojo;

import com.google.gson.annotations.SerializedName;

public class LoginPOJO {

    @SerializedName("userid")
    private String userId;
    @SerializedName("userfirstname")
    private String userFN;
    @SerializedName("userlastname")
    private String userLN;
    @SerializedName("useremail")
    private String userEmail;
    @SerializedName("appapikey")
    private String apiKey;
    @SerializedName("userrole")
    private String role;

    public LoginPOJO(String userId, String userFN, String userLN, String userEmail, String apiKey, String role) {
        this.userId = userId;
        this.userFN = userFN;
        this.userLN = userLN;
        this.userEmail = userEmail;
        this.apiKey = apiKey;
        this.role = role;
    }

    @Override
    public String toString() {
        return "LoginPOJO{" +
                "userId='" + userId + '\'' +
                ", userFN='" + userFN + '\'' +
                ", userLN='" + userLN + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", apiKey='" + apiKey + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserFN() {
        return userFN;
    }

    public void setUserFN(String userFN) {
        this.userFN = userFN;
    }

    public String getUserLN() {
        return userLN;
    }

    public void setUserLN(String userLN) {
        this.userLN = userLN;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
