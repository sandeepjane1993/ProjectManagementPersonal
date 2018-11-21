package com.example.sande.projectmanagementpersonal.assignteammembers;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.sande.projectmanagementpersonal.MyApplication;
import com.example.sande.projectmanagementpersonal.R;
import com.example.sande.projectmanagementpersonal.network.ApiService;
import com.example.sande.projectmanagementpersonal.responses.ProjectCreateResponse;
import com.example.sande.projectmanagementpersonal.responses.ProjectListResponse;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

import static android.content.Context.MODE_PRIVATE;
import static android.support.constraint.Constraints.TAG;

public class AssignSubTaskMember extends Fragment {

    @Inject
    SharedPreferences sharedPreferences;
    @Inject
    Retrofit retrofit;

    ApiService apiService;
    @BindView(R.id.id_assignsubtask)
    EditText idAssignsubtask;
    @BindView(R.id.btn_assignsubtask)
    Button btnAssignsubtask;
    Unbinder unbinder;

    private static final String TAG = "AssignSubTaskMember";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_assign_member_tosubtask, container, false);

        sharedPreferences = getActivity().getSharedPreferences("MyFile",MODE_PRIVATE);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        ((MyApplication) context.getApplicationContext()).getComponentInstance().injectRetrofit(this);
        super.onAttach(context);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btn_assignsubtask)
    public void onViewClicked() {

        String taskId = sharedPreferences.getString("taskId",null);
        String subTaskId = sharedPreferences.getString("subTaskId",null);
        String projectId = sharedPreferences.getString("projectId",null);
        String memberId = idAssignsubtask.getText().toString();
        apiService = retrofit.create(ApiService.class);
        apiService.assignSubTaskToMember(taskId,subTaskId,projectId,memberId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this:: responseResult, this:: errorResult);
    }

    private void responseResult(ProjectCreateResponse projectCreateResponse) {
        Log.i(TAG, "responseResult: " + projectCreateResponse.getProjectCreateResponse().get(0));
    }


    private void errorResult(Throwable throwable) {
        Log.i(TAG, "errorResult: " + throwable.getMessage());
    }
}
