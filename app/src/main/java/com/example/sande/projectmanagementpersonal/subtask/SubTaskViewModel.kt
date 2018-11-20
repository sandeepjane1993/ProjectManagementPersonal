package com.example.sande.projectmanagementpersonal.subtask

import android.app.Application
import android.content.Context
import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.example.sande.projectmanagementpersonal.adapters.SubTaskListAdapter
import com.example.sande.projectmanagementpersonal.pojo.SubTaskListPOJO

class SubTaskViewModel (val subTaskListFragment : SubTaskListFragment, context: Context) : BaseObservable() {

    val subTaskRepository : SubTaskRepository = SubTaskRepository(this, context)

    var subTaskList : List<SubTaskListPOJO>? = null

    val context : Context = context


    fun initsubTaskList() {

        subTaskRepository.getSubTask(context)

//        Log.i("kotlin", (subTaskList as MutableList<SubTaskListPOJO>?).get(0).toString())

//        return subTaskList as? MutableList<SubTaskListPOJO>
    }


    fun subTaskList(subTaskList : List<SubTaskListPOJO>) {
        subTaskListFragment.initRV(subTaskList)
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