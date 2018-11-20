package com.example.sande.projectmanagementpersonal.viewtaskByid.ViewTeamMenberByTask

import android.content.Context
import android.util.Log
import com.example.sande.projectmanagementpersonal.MyApplication
import com.example.sande.projectmanagementpersonal.network.ApiService
import com.example.sande.projectmanagementpersonal.pojo.EmployeePOJO
import com.example.sande.projectmanagementpersonal.responses.CreateTeamResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import javax.inject.Inject

class EmployeeDetailRepository(val context: Context?, val employeeViewModel: EmployeeDetailViewModel) {

    @Inject
    internal lateinit var retrofit : Retrofit

//    private var subTaskList: List<SubTaskListPOJO>? = null

    var apiService : ApiService

    init {
        (this.context?.applicationContext as MyApplication).getComponentInstance().injectRetrofit(this)

        apiService = retrofit.create(ApiService::class.java)
    }

    fun initEmployeeList(menberid:String) {

        apiService.getEmployeeDetail(menberid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer<EmployeeDetailPOJO> { this.responseResult(it) }, Consumer<Throwable> { this.errorResult(it) })
    }

    private fun responseResult(response: EmployeeDetailPOJO) {
        Log.i("tag1",response.toString())
        employeeViewModel.showemployeedetail(response)
    }

    private fun errorResult(it: Throwable) {
        Log.e("error", it.toString())
    }


}