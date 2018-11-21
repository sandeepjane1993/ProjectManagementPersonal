package com.example.sande.projectmanagementpersonal.priority

import android.content.Context
import android.util.Log
import com.example.sande.projectmanagementpersonal.MyApplication
import com.example.sande.projectmanagementpersonal.network.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import javax.inject.Inject



class SubTaskPriorityRepository(val context: Context?, val subTaskPriorityViewModel: SubTaskPriorityViewModel) {

    @Inject
    internal lateinit var retrofit : Retrofit

//    private var subTaskList: List<SubTaskListPOJO>? = null

    var apiService : ApiService

    init {
        (this.context?.applicationContext as MyApplication).getComponentInstance().injectRetrofit(this)

        apiService = retrofit.create(ApiService::class.java)
    }

    fun callwebwservice(A:String,B:String,C:String,D:String) {

        apiService.getSubTaskPriority(A,B,C,D)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer<SubTaskPriorityPojo> { this.responseResult(it) }, Consumer<Throwable> { this.errorResult(it) })
    }

    private fun responseResult(response: SubTaskPriorityPojo) {
        Log.i("tag1",response.toString())
        subTaskPriorityViewModel.showePriority(response)
    }

    private fun errorResult(it: Throwable) {
        Log.e("error", it.toString())
    }


}
