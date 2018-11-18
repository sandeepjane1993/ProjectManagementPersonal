package com.example.sande.projectmanagementpersonal.viewtaskByid.ViewSubTaskListById;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ViewSubTaskListByIdResponce {

    @SerializedName("viewsubtasks")
    private List<ViewSubTaskListByIdPojo> viewSubTaskListByIdPojos;

    public ViewSubTaskListByIdResponce(List<ViewSubTaskListByIdPojo> viewSubTaskListByIdPojos) {
        this.viewSubTaskListByIdPojos = viewSubTaskListByIdPojos;
    }

    public List<ViewSubTaskListByIdPojo> getViewSubTaskListByIdPojos() {
        return viewSubTaskListByIdPojos;
    }

    public void setViewSubTaskListByIdPojos(List<ViewSubTaskListByIdPojo> viewSubTaskListByIdPojos) {
        this.viewSubTaskListByIdPojos = viewSubTaskListByIdPojos;
    }

    @Override
    public String toString() {
        return "TenantResponse{" +
                "viewSubTaskListByIdPojos=" + viewSubTaskListByIdPojos +
                '}';
    }
}
