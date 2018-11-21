package com.example.sande.projectmanagementpersonal.team

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.util.Log
import com.example.sande.projectmanagementpersonal.MyApplication
import com.example.sande.projectmanagementpersonal.network.ApiService
import com.example.sande.projectmanagementpersonal.pojo.EmployeePOJO
import com.example.sande.projectmanagementpersonal.pojo.SubTaskListPOJO
import com.example.sande.projectmanagementpersonal.responses.CreateTeamResponse
import com.example.sande.projectmanagementpersonal.responses.EmployeeListResponse
import com.example.sande.projectmanagementpersonal.responses.MemberOfSubtaskResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import javax.inject.Inject

class EmployeeRepository(val context: Context?, val employeeViewModel: EmployeeViewModel) {

    @Inject
    internal lateinit var retrofit : Retrofit

    @Inject
    lateinit var sharedPreferences : SharedPreferences

//    private var subTaskList: List<SubTaskListPOJO>? = null

    var apiService : ApiService

    init {
        (this.context?.applicationContext as MyApplication).getComponentInstance().injectRetrofit(this)

        sharedPreferences = context.getSharedPreferences("MyFile", MODE_PRIVATE)

        apiService = retrofit.create(ApiService::class.java)
    }

    fun initEmployeeList() {

        apiService.getEmployeeList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer<EmployeeListResponse> { this.responseResult(it) }, Consumer<Throwable> { this.errorResult(it) })
    }

    private fun responseResult(employeeListResponse: EmployeeListResponse) {
        var employeeList : List<EmployeePOJO> = employeeListResponse.employeePOJOList
        employeeViewModel.getEmployeeList(employeeList)
    }

    private fun errorResult(it: Throwable) {

    }

    fun addEmployee(employeeId: String, projectId: String?) {

        apiService.createTeam(employeeId, projectId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer<CreateTeamResponse> {this.responseAddEmployeeResult(it)},
                        Consumer<Throwable> { this.errorResult(it) })
    }

    private fun responseAddEmployeeResult(it: CreateTeamResponse) {
        var info : String = it.getMessage().get(0)
        employeeViewModel.showAddEmployeeInfo(info)
    }

    fun getEmployeeListBySubtask() {
        val taskId = sharedPreferences.getString("taskId", "")
        val subtaskId = sharedPreferences.getString("subTaskId", "")
        val projectId = sharedPreferences.getString("projectId", "")

        Log.i("mst", "taskId: " + taskId)
        Log.i("mst", "subtaskId: " + subtaskId)
        Log.i("mst", "projectId: " + projectId)

        apiService.getMemberOfSubtask(taskId, subtaskId, projectId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer<MemberOfSubtaskResponse> {this.responseMemberOfSubtask(it)},
                        Consumer<Throwable> { this.errorResult(it) })
    }

    private fun responseMemberOfSubtask(it: MemberOfSubtaskResponse) {
        val memberOfSubtaskList = it.memberOfSubtaskPOJOList
        employeeViewModel.showMemberOfSubtask(memberOfSubtaskList)
    }
}