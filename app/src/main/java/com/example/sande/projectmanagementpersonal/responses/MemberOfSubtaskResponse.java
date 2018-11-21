package com.example.sande.projectmanagementpersonal.responses;

import com.example.sande.projectmanagementpersonal.pojo.MemberOfSubtaskPOJO;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MemberOfSubtaskResponse {

    @SerializedName("members")
    List<MemberOfSubtaskPOJO> memberOfSubtaskPOJOList;

    public MemberOfSubtaskResponse(List<MemberOfSubtaskPOJO> memberOfSubtaskPOJOList) {
        this.memberOfSubtaskPOJOList = memberOfSubtaskPOJOList;
    }

    public List<MemberOfSubtaskPOJO> getMemberOfSubtaskPOJOList() {
        return memberOfSubtaskPOJOList;
    }
}
