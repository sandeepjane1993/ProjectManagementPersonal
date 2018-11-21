package com.example.sande.projectmanagementpersonal.allviewmodels;

import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sande.projectmanagementpersonal.network.ApiService;
import com.example.sande.projectmanagementpersonal.network.RetrofitInstance;
import com.example.sande.projectmanagementpersonal.pojo.AssignTaskPOJO;
import com.example.sande.projectmanagementpersonal.responses.ProjectCreateResponse;
import com.example.sande.projectmanagementpersonal.BR;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

public class AssignTaskViewModel extends BaseObservable {

    private static final String TAG = "AssignTaskViewModel";
    EditText editText;
    String res;
    private Context context;
    private AssignTaskPOJO assignTaskPOJO;
    private SharedPreferences sharedPreferences;

    public AssignTaskViewModel(Context context) {
        this.context = context;
        this.assignTaskPOJO = new AssignTaskPOJO();
        sharedPreferences = context.getSharedPreferences("MyFile",MODE_PRIVATE);
    }

    public void setUserId(String userId)
    {
        assignTaskPOJO.setUserId(userId);
        notifyPropertyChanged(BR.response);
    }

    @Bindable
    public String getResponse()
    {
        String taskId = sharedPreferences.getString("taskId",null);
        String projectId = sharedPreferences.getString("projectId",null);
        String userId = assignTaskPOJO.getUserId();

        ApiService apiService = RetrofitInstance.getRetrofitJsonInstance().create(ApiService.class);

        Call<ProjectCreateResponse> call = apiService.assignTaskToMember(taskId,projectId,userId);

        call.enqueue(new Callback<ProjectCreateResponse>() {
            @Override
            public void onResponse(Call<ProjectCreateResponse> call, Response<ProjectCreateResponse> response) {

                ProjectCreateResponse assignResponse = response.body();
                 res =  assignResponse.getProjectCreateResponse().get(0);

            }
            @Override
            public void onFailure(Call<ProjectCreateResponse> call, Throwable t) {

            }
        });
        Log.i(TAG, "getResponse: " + taskId + "\n" + projectId + "\n" + userId);
        return res;

    }

    public View.OnClickListener buttonClick()
    {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, "" + getResponse(), Toast.LENGTH_SHORT).show();
            }
        };
    }
}
