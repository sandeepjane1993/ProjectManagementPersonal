package com.example.sande.projectmanagementpersonal.subtask

import com.example.sande.projectmanagementpersonal.pojo.SubTaskListPOJO
import com.example.sande.projectmanagementpersonal.responses.UpdateSubtaskResponse

interface SubTaskInterface {

    fun initRV(subTaskList : List<SubTaskListPOJO>)

    fun updateSubTaskResponse(updateSubtaskResponse: UpdateSubtaskResponse)
}