package com.example.sande.projectmanagementpersonal.tasks

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.content.Context
import android.content.SharedPreferences
import android.databinding.Bindable
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.sande.projectmanagementpersonal.network.ApiService
import com.example.sande.projectmanagementpersonal.network.RetrofitInstance
import com.example.sande.projectmanagementpersonal.responses.UpdateSubtaskResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TaskViewModel(application: Application) : AndroidViewModel(application) {

//    var taskRepository : TaskRepository

    private var response : String = ""

    lateinit var status : String

    lateinit  var sharedPreferences : SharedPreferences

    var apiService : ApiService

    var myList : MutableList<String> = mutableListOf()


    init {
//        taskRepository = TaskRepository(application)

        sharedPreferences = application.getSharedPreferences("MyFile", Context.MODE_PRIVATE)

//        apiService = retrofit.create(ApiService::class.java)
        apiService = RetrofitInstance.getRetrofitJsonInstance().create(ApiService::class.java)
    }

    fun updateTask(status: String) {
        Log.i("123", "yes-2")
        this.status = status
//        this.response = taskRepository.getResponse(status).get(0)
        val taskid = sharedPreferences.getString("taskId", null)
        val project_id = sharedPreferences.getString("projectId", null)
//        val userid = sharedPreferences.getString("userId", null)

        val userid = "14"


        Log.i("123", "taskId: " + taskid)

        val call : Call<UpdateSubtaskResponse> = apiService.updateTask(taskid, project_id, userid, status)

        call.enqueue(object : Callback<UpdateSubtaskResponse> {
            override fun onResponse(call: Call<UpdateSubtaskResponse>, response: Response<UpdateSubtaskResponse>) {

                val taskListResponse = response.body()
                myList = taskListResponse!!.getMessage()
                if (myList == null || myList.size == 0) {
                    Log.i("123", "wt1")
                }
                else {
                    Log.i("123", "yes1: " + myList.get(0))
                }
            }

            override fun onFailure(call: Call<UpdateSubtaskResponse>, t: Throwable) {

            }
        })
    }

    fun buttonClick(): View.OnClickListener {
        return View.OnClickListener {
            updateTask(status)

            if (myList == null || myList.size == 0) {
                Log.i("123", "wt2")
            }
            else {
                Log.i("123", "yes2: " + myList.get(0))
            }

            response = myList.get(0)

            Toast.makeText(getApplication(), response, Toast.LENGTH_SHORT).show()
            Log.i("123", "yes-1")
        }
    }

/*    fun setStatus(response : String) {
        status = response
    }*/

    @Bindable
    fun getResponse() : String {
        return response
    }


}