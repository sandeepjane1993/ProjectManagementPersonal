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

import com.example.sande.projectmanagementpersonal.BuildConfig;
import com.example.sande.projectmanagementpersonal.MyApplication;
import com.example.sande.projectmanagementpersonal.R;
import com.example.sande.projectmanagementpersonal.assignteammembers.AssignSubTaskMember;
import com.example.sande.projectmanagementpersonal.priority.SubTaskPriorityFragment;
import com.example.sande.projectmanagementpersonal.team.MemberOfSubTaskFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static android.content.Context.MODE_PRIVATE;

public class SubTaskDetailFragment extends Fragment {

    @Inject
    SharedPreferences sharedPreferences;
    @BindView(R.id.btn_addsubtaskMenber)
    Button btnAddsubtaskMenber;
    @BindView(R.id.btn_updatetaskstatus)
    Button btnUpdatetaskstatus;
    @BindView(R.id.goToSubTasksmenber)
    Button goToSubTasksmenber;
    Unbinder unbinder;
    @BindView(R.id.goToSubTaskpriority)
    Button goToSubTaskpriority;

    private static final String TAG = "SubTaskDetailFragment";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_subtask_details, container, false);
        sharedPreferences = getActivity().getSharedPreferences("MyFile", MODE_PRIVATE);
        if(BuildConfig.FLAVOR.equalsIgnoreCase("user")){
            btnAddsubtaskMenber = (Button) view.findViewById(R.id.btn_addsubtaskMenber);
            btnAddsubtaskMenber.setVisibility(View.GONE);
            btnUpdatetaskstatus = (Button) view.findViewById(R.id.btn_updatetaskstatus);
            btnUpdatetaskstatus.setVisibility(View.GONE);

        }
        unbinder = ButterKnife.bind(this, view);
        Log.i(TAG, "onCreateView: " + sharedPreferences.getString("subTaskId",""));

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

    @OnClick({R.id.btn_addsubtaskMenber, R.id.btn_updatetaskstatus, R.id.goToSubTasksmenber,R.id.goToSubTaskpriority})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_addsubtaskMenber:
                getFragmentManager().beginTransaction().replace(R.id.container, new AssignSubTaskMember()).addToBackStack("").commit();
                break;
            case R.id.btn_updatetaskstatus:
                getFragmentManager().beginTransaction().replace(R.id.container,
                        new SubTaskUpdateFragment(), null).addToBackStack("null").commit();
                break;
            case R.id.goToSubTasksmenber:
                getFragmentManager().beginTransaction().replace(R.id.container,
                        new MemberOfSubTaskFragment(), null).addToBackStack("null").commit();
                break;
            case R.id.goToSubTaskpriority:
                getFragmentManager().beginTransaction().replace(R.id.container,
                        new SubTaskPriorityFragment()).addToBackStack("null").commit();
                break;
        }
    }
}
