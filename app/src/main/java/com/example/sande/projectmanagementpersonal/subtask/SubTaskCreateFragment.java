package com.example.sande.projectmanagementpersonal.subtask;

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

public class SubTaskCreateFragment extends Fragment {

    @Inject
    SharedPreferences sharedPreferences;

    @Inject
    Retrofit retrofit;

    @BindView(R.id.et_SubTaskName_STC)
    EditText etSubTaskNameSTC;
    @BindView(R.id.et_SubTaskStatus_STC)
    EditText etSubTaskStatusSTC;
    @BindView(R.id.et_SubTaskDesc_STC)
    EditText etSubTaskDescSTC;
    @BindView(R.id.et_SubStartDate_STC)
    EditText etSubStartDateSTC;
    @BindView(R.id.et_SubEndDate_STC)
    EditText etSubEndDateSTC;
    @BindView(R.id.btn_createTask_STC)
    Button btnCreateTaskSTC;
    Unbinder unbinder;

    private static final String TAG = "SubTaskCreateFragment";
    TextView tv_pn_STC,tv_tn_STC;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_subtask, container, false);

        sharedPreferences = getActivity().getSharedPreferences("MyFile",MODE_PRIVATE);
        tv_pn_STC = view.findViewById(R.id.tv_Pn_STC);
        tv_tn_STC = view.findViewById(R.id.tv_Tn_STC);
        tv_pn_STC.setText(sharedPreferences.getString("projectName",""));
        tv_tn_STC.setText(sharedPreferences.getString("taskName",""));


        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btn_createTask_STC)
    public void onViewClicked() {

        String projectId = sharedPreferences.getString("projectId",null);
        String taskId = sharedPreferences.getString("taskId",null);
        String name = etSubTaskNameSTC.getText().toString();
        String status = etSubTaskStatusSTC.getText().toString();
        String desc = etSubTaskDescSTC.getText().toString();
        String start = etSubStartDateSTC.getText().toString();
        String end = etSubEndDateSTC.getText().toString();

        ApiService apiService = retrofit.create(ApiService.class);
        apiService.createSubTask(projectId,taskId,name,status,desc,start,end)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this:: responseResult, this:: errorResult);
    }

    private void responseResult(ProjectCreateResponse projectCreateResponse) {
        Log.i(TAG, "responseResult: " + projectCreateResponse.getProjectCreateResponse().get(0));
        Toast.makeText(getActivity(), "" + projectCreateResponse.getProjectCreateResponse().get(0) , Toast.LENGTH_SHORT).show();
        getFragmentManager().beginTransaction().replace(R.id.container,new SubTaskListFragment()).addToBackStack("").commit();
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
