package com.example.sande.projectmanagementpersonal.viewtaskByid.ViewTaskLiskById;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.List;

public class ViewTaskListByIdResponce {

    @SerializedName("view tasks")
    private List<ViewTaskListByIdPojo> viewTaskListByIdPojos;

    public ViewTaskListByIdResponce(List<ViewTaskListByIdPojo> viewTaskListByIdPojos) {
        this.viewTaskListByIdPojos = viewTaskListByIdPojos;
    }

    public List<ViewTaskListByIdPojo> getViewTaskListByIdPojos() {
        return viewTaskListByIdPojos;
    }

    public void setViewTaskListByIdPojos(List<ViewTaskListByIdPojo> viewTaskListByIdPojos) {
        this.viewTaskListByIdPojos = viewTaskListByIdPojos;
    }

    @Override
    public String toString() {
        return "TenantResponse{" +
                "viewTaskListByIdPojos=" + viewTaskListByIdPojos +
                '}';
    }
}
