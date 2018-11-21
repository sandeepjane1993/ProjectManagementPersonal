package com.example.sande.projectmanagementpersonal.subtask

import android.content.Context
import android.databinding.BaseObservable
import com.example.sande.projectmanagementpersonal.pojo.SubTaskListPOJO
import com.example.sande.projectmanagementpersonal.responses.UpdateSubtaskResponse

class SubTaskViewModel (val generalSubTaskFragment : SubTaskInterface, val context: Context?) : BaseObservable() {

    val subTaskRepository : SubTaskRepository = SubTaskRepository(this, context)

    var subTaskList : List<SubTaskListPOJO>? = null

    fun initsubTaskList() {

        subTaskRepository.getSubTask(context)

//        Log.i("kotlin", (subTaskList as MutableList<SubTaskListPOJO>?).get(0).toString())

//        return subTaskList as? MutableList<SubTaskListPOJO>
    }


    fun subTaskList(subTaskList : List<SubTaskListPOJO>) {
        generalSubTaskFragment.initRV(subTaskList)
    }

    fun updateSubTask(status: String) {
        subTaskRepository.updateSubTask(status);
    }

    fun updateSubTaskResponse(updateSubtaskResponse: UpdateSubtaskResponse) {
        generalSubTaskFragment.updateSubTaskResponse(updateSubtaskResponse);
    }

/*    @get:Bindable
    var subTaskList : MutableList<SubTaskListPOJO> = mutableListOf()
        private set(value) {
            field = value
            notifyPropertyChanged(BR.subTaskViewModel)
        }

    @BindingAdapter("data")
    fun <T> setRecyclerViewProperties(recyclerView: RecyclerView, items: List<SubTaskListPOJO>) {
        if (recyclerView.adapter is SubTaskListAdapter) {
            (recyclerView.adapter as SubTaskListAdapter).setData(items)
        }
    }*/

}