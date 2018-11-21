package com.example.sande.projectmanagementpersonal.subtask;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.example.sande.projectmanagementpersonal.MyApplication;
import com.example.sande.projectmanagementpersonal.network.ApiService;
import com.example.sande.projectmanagementpersonal.pojo.SubTaskListPOJO;
import com.example.sande.projectmanagementpersonal.responses.SubTaskListResponse;
import com.example.sande.projectmanagementpersonal.responses.UpdateSubtaskResponse;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

import static android.content.Context.MODE_PRIVATE;

public class SubTaskRepository {

    @Inject
    Retrofit retrofit;

    @Inject
    SharedPreferences sharedPreferences;

    private static final String TAG = "SubTaskRepository";

    private ApiService apiService;

    private List<SubTaskListPOJO> subTaskList;

    private Context context;

    SubTaskViewModel subTaskViewModel;

    public SubTaskRepository(SubTaskViewModel subTaskViewModel, Context context) {
        this.context = context;
        this.subTaskViewModel = subTaskViewModel;

        ((MyApplication) this.context.getApplicationContext()).getComponentInstance().injectRetrofit(this);
        sharedPreferences = context.getSharedPreferences("MyFile", MODE_PRIVATE);
    }

    public void getSubTask(Context context) {
        apiService = retrofit.create(ApiService.class);
        apiService.getSubTaskList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::responseResult, this::errorResult);

    }

    private void responseResult(SubTaskListResponse subTaskListResponse) {
        Log.i(TAG, "responseResult: yes");

        subTaskList = subTaskListResponse.getSubTaskListResponse();



        subTaskViewModel.subTaskList(subTaskList);

    }
    
    private void errorResult(Throwable throwable) {
        Log.i(TAG, "errorResult: no");
    }


    public void updateSubTask(String status) {

        String subtaskid = sharedPreferences.getString("subTaskId", null);
        String taskid = sharedPreferences.getString("taskId", null);
        String project_id = sharedPreferences.getString("projectId", null);
        String userid = sharedPreferences.getString("userId", null);

        apiService = retrofit.create(ApiService.class);


        apiService.updateSubtask(subtaskid, taskid, project_id, userid, status)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::updateSubTaskResponseResult, this::errorResult);
    }

    private void updateSubTaskResponseResult(UpdateSubtaskResponse updateSubtaskResponse) {

        subTaskViewModel.updateSubTaskResponse(updateSubtaskResponse);
    }


}


