package com.example.sande.projectmanagementpersonal.subtask;

import android.content.Context;
import android.util.Log;

import com.example.sande.projectmanagementpersonal.MyApplication;
import com.example.sande.projectmanagementpersonal.network.ApiService;
import com.example.sande.projectmanagementpersonal.pojo.SubTaskListPOJO;
import com.example.sande.projectmanagementpersonal.responses.SubTaskListResponse;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class SubTaskRepository {

    @Inject
    Retrofit retrofit;

    private static final String TAG = "SubTaskRepository";

    private ApiService apiService;

    private List<SubTaskListPOJO> subTaskList;

    private Context context;

    SubTaskViewModel subTaskViewModel;

    public SubTaskRepository(SubTaskViewModel subTaskViewModel, Context context) {
        this.context = context;
        this.subTaskViewModel = subTaskViewModel;
    }

    public void getSubTask(Context context) {

        ((MyApplication) this.context.getApplicationContext()).getComponentInstance().injectRetrofit(this);

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


}


