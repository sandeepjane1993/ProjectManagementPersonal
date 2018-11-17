package com.example.sande.projectmanagementpersonal.project;

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

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

import static android.content.Context.MODE_PRIVATE;

public class ProjectUpdateFragment extends Fragment {

    @Inject
    SharedPreferences sharedPreferences;
    @Inject
    Retrofit retrofit;

    @BindView(R.id.et_ProjectName_PU)
    EditText etProjectNamePU;
    @BindView(R.id.et_ProjectStatus_PU)
    EditText etProjectStatusPU;
    @BindView(R.id.et_ProjectDesc_PU)
    EditText etProjectDescPU;
    @BindView(R.id.et_StartDate_PU)
    EditText etStartDatePU;
    @BindView(R.id.et_EndDate_PU)
    EditText etEndDatePU;
    @BindView(R.id.btn_UpdateProject_PU)
    Button btnUpdateProjectPU;
    Unbinder unbinder;

    private static final String TAG = "ProjectUpdateFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_update_project, container, false);

        sharedPreferences = getActivity().getSharedPreferences("MyFile",MODE_PRIVATE);
        String id = sharedPreferences.getString("projectId",null);
        Log.i(TAG, "onCreateView: " + id);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btn_UpdateProject_PU)
    public void onViewClicked() {

        String id = sharedPreferences.getString("projectId",null);
        String name = etProjectNamePU.getText().toString();
        String status = etProjectStatusPU.getText().toString();
        String desc = etProjectDescPU.getText().toString();
        String start = etStartDatePU.getText().toString();
        String end = etEndDatePU.getText().toString();

        ApiService apiService = retrofit.create(ApiService.class);
        apiService.updateProject(id,name,status,desc,start,end)
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

    @Override
    public void onAttach(Context context) {
        //((MyApplication) context.getApplicationContext()).getSpComponentInstance().injectRetrofit(this);
        ((MyApplication) context.getApplicationContext()).getComponentInstance().injectRetrofit(this);
        super.onAttach(context);
    }
}
