package com.example.sande.projectmanagementpersonal.tasks

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.example.sande.projectmanagementpersonal.MyApplication
import com.example.sande.projectmanagementpersonal.network.ApiService
import com.example.sande.projectmanagementpersonal.network.RetrofitInstance
import com.example.sande.projectmanagementpersonal.responses.UpdateSubtaskResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import java.util.*
import javax.inject.Inject

class TaskRepository  (val context: Context?)  {

/*    @Inject
    lateinit var retrofit: Retrofit*/


    lateinit  var sharedPreferences : SharedPreferences

    var apiService : ApiService

    init {
        (this.context?.applicationContext as MyApplication).getComponentInstance().injectTaskRepositoryRetrofit(this)

         sharedPreferences = context.getSharedPreferences("MyFile", Context.MODE_PRIVATE)

//        apiService = retrofit.create(ApiService::class.java)
        apiService = RetrofitInstance.getRetrofitJsonInstance().create(ApiService::class.java)
    }

    fun getResponse(status: String): MutableList<String> {

        Log.i("123", "yes0")

        val taskid = sharedPreferences.getString("taskId", null)
        val project_id = sharedPreferences.getString("projectId", null)
//        val userid = sharedPreferences.getString("userId", null)
        val userid = "14"

        val call : Call<UpdateSubtaskResponse> = apiService.updateTask(taskid, project_id, userid, status)

        var myList : MutableList<String> = mutableListOf()

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

        if (myList == null || myList.size == 0) {
            Log.i("123", "wt2")
        }
        else {
            Log.i("123", "yes2: " + myList.get(0))
        }

        return myList
    }

    private fun updateTaskResponseResult(it: UpdateSubtaskResponse) {

    }
}