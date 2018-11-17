package com.example.sande.projectmanagementpersonal.pojo;

import com.google.gson.annotations.SerializedName;

public class ForgotPasswordPOJO {

    @SerializedName("msg")
    private String message;
    @SerializedName("useremail")
    private String email;
    @SerializedName("userpassword")
    private String password;

    public ForgotPasswordPOJO(String message, String email, String password) {
        this.message = message;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "ForgotPasswordPOJO{" +
                "message='" + message + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
