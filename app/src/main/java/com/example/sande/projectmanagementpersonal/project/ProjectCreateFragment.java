package com.example.sande.projectmanagementpersonal.project;

import android.content.Context;
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
import android.widget.Toast;

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

public class ProjectCreateFragment extends Fragment {

    @Inject
    Retrofit retrofit;

    @BindView(R.id.et_ProjectName_PC)
    EditText etProjectNamePC;
    @BindView(R.id.et_ProjectStatus_PC)
    EditText etProjectStatusPC;
    @BindView(R.id.et_ProjectDesc_PC)
    EditText etProjectDescPC;
    @BindView(R.id.et_StartDate_PC)
    EditText etStartDatePC;
    @BindView(R.id.et_EndDate_PC)
    EditText etEndDatePC;
    @BindView(R.id.btn_createProject_PC)
    Button btnCreateProjectPC;
    Unbinder unbinder;

    private static final String TAG = "ProjectCreateFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_create_project, container, false);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btn_createProject_PC)
    public void onViewClicked() {

        String name = etProjectNamePC.getText().toString();
        String status = etProjectStatusPC.getText().toString();
        String desc = etProjectDescPC.getText().toString();
        String start = etStartDatePC.getText().toString();
        String end = etEndDatePC.getText().toString();

        ApiService apiService = retrofit.create(ApiService.class);
        apiService.createProject(name,status,desc,start,end)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this:: responseResult, this:: errorResult);
    }

    private void responseResult(ProjectCreateResponse projectCreateResponse) {
        Log.i(TAG, "responseResult: " + projectCreateResponse.getProjectCreateResponse().get(0));
        Toast.makeText(getActivity(), "" + projectCreateResponse.getProjectCreateResponse().get(0) , Toast.LENGTH_SHORT).show();
        getFragmentManager().beginTransaction().replace(R.id.container,new ProjectListFragment()).addToBackStack("").commit();
    }

    private void errorResult(Throwable throwable) {
        Log.i(TAG, "errorResult: " + throwable.getMessage());
    }

    @Override
    public void onAttach(Context context) {
        ((MyApplication) context.getApplicationContext()).getComponentInstance().injectRetrofit(this);
        super.onAttach(context);
    }
}
