package com.example.sande.projectmanagementpersonal.tasks;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.sande.projectmanagementpersonal.MyApplication;
import com.example.sande.projectmanagementpersonal.R;
import com.example.sande.projectmanagementpersonal.subtask.SubTaskListFragment;
import com.example.sande.projectmanagementpersonal.viewtaskByid.ViewTeamMenberByTask.ViewTeamMenberByTask;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static android.content.Context.MODE_PRIVATE;

public class TaskDetailFragment extends Fragment {

    @Inject
    SharedPreferences sharedPreferences;

    @BindView(R.id.btn_addtaskMenber)
    Button btnAddtaskMenber;
    @BindView(R.id.btn_updatetaskstatus)
    Button btnUpdatetaskstatus;
    @BindView(R.id.goToSubTasksList)
    Button goToSubTasksList;
    Unbinder unbinder;
    @BindView(R.id.goToTasksmenber)
    Button goToTasksmenber;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_task_details, container, false);
        sharedPreferences = getActivity().getSharedPreferences("MyFile", MODE_PRIVATE);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.btn_addtaskMenber, R.id.btn_updatetaskstatus, R.id.goToSubTasksList})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_addtaskMenber:
                break;
            case R.id.btn_updatetaskstatus:
                break;
            case R.id.goToSubTasksList:

                Bundle bundle = new Bundle();
                bundle.putString("taskId", sharedPreferences.getString("taskId", null));
                SubTaskListFragment subTaskListFragment = new SubTaskListFragment();
                subTaskListFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.container,
                        subTaskListFragment).addToBackStack("null").commit();
                break;
        }
    }


    @Override
    public void onAttach(Context context) {
        ((MyApplication) context.getApplicationContext()).getComponentInstance().injectRetrofit(this);
        super.onAttach(context);

    }

    @OnClick(R.id.goToTasksmenber)
    public void onViewClicked() {
        getFragmentManager().beginTransaction().replace(R.id.container,
                new ViewTeamMenberByTask()).addToBackStack("null").commit();
    }
}
