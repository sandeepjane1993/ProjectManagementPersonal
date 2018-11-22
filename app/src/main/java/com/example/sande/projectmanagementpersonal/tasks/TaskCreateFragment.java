package com.example.sande.projectmanagementpersonal.tasks;

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
import android.widget.TextView;
import android.widget.Toast;

import com.example.sande.projectmanagementpersonal.MyApplication;
import com.example.sande.projectmanagementpersonal.R;
import com.example.sande.projectmanagementpersonal.network.ApiService;
import com.example.sande.projectmanagementpersonal.project.ProjectListFragment;
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

public class TaskCreateFragment extends Fragment {

    @Inject
    SharedPreferences sharedPreferences;

    @Inject
    Retrofit retrofit;

    @BindView(R.id.et_TaskName_TC)
    EditText etTaskNameTC;
    @BindView(R.id.et_TaskStatus_TC)
    EditText etTaskStatusTC;
    @BindView(R.id.et_TaskDesc_TC)
    EditText etTaskDescTC;
    @BindView(R.id.et_StartDate_TC)
    EditText etStartDateTC;
    @BindView(R.id.et_EndDate_TC)
    EditText etEndDateTC;
    @BindView(R.id.btn_createTask_TC)
    Button btnCreateTaskTC;
    Unbinder unbinder;

    private static final String TAG = "TaskCreateFragment";
    TextView tv_pn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_create_task, container, false);

        sharedPreferences = getActivity().getSharedPreferences("MyFile",MODE_PRIVATE);
        tv_pn = view.findViewById(R.id.tv_Pn);
        tv_pn.setText(sharedPreferences.getString("projectName",""));


        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btn_createTask_TC)
    public void onViewClicked() {

        String projectId = sharedPreferences.getString("projectId",null);
        Log.i(TAG, "onViewClicked: projID" + projectId);
        String name = etTaskNameTC.getText().toString();
        String status = etTaskStatusTC.getText().toString();
        String desc = etTaskDescTC.getText().toString();
        String start = etStartDateTC.getText().toString();
        String end = etEndDateTC.getText().toString();

        ApiService apiService = retrofit.create(ApiService.class);
        apiService.createTask(projectId,name,status,desc,start,end)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this:: responseResult, this:: errorResult);
    }

    private void responseResult(ProjectCreateResponse projectCreateResponse) {
        Log.i(TAG, "responseResult: " + projectCreateResponse.getProjectCreateResponse().get(0));
        Toast.makeText(getActivity(), "" + projectCreateResponse.getProjectCreateResponse().get(0) , Toast.LENGTH_SHORT).show();
        getFragmentManager().beginTransaction().replace(R.id.container,new TaskListFragment()).addToBackStack("").commit();
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
