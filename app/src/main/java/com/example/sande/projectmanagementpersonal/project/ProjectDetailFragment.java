package com.example.sande.projectmanagementpersonal.project;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.sande.projectmanagementpersonal.BuildConfig;
import com.example.sande.projectmanagementpersonal.R;
import com.example.sande.projectmanagementpersonal.tasks.TaskListFragment;
import com.example.sande.projectmanagementpersonal.team.CreateTeamFragment;
import com.example.sande.projectmanagementpersonal.viewtaskByid.ViewTaskLiskById.ViewTaskListByIDFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static android.content.Context.MODE_PRIVATE;

public class ProjectDetailFragment extends Fragment {

    SharedPreferences sharedPreferences;
    @BindView(R.id.btn_goToUpdateProject)
    Button btnGoToUpdateProject;
    @BindView(R.id.goToTasksList)
    Button goToTasksList;
    Unbinder unbinder;
    @BindView(R.id.btn_createTeam)
    Button btnCreateTeam;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_project_details, container, false);

        sharedPreferences = getActivity().getSharedPreferences("MyFile",MODE_PRIVATE);

        if(BuildConfig.FLAVOR.equalsIgnoreCase("user")){
            btnGoToUpdateProject = (Button) view.findViewById(R.id.btn_goToUpdateProject);
            btnGoToUpdateProject.setVisibility(View.GONE);
            btnCreateTeam = (Button) view.findViewById(R.id.btn_createTeam);
            btnCreateTeam.setVisibility(View.GONE);
        }


        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.btn_goToUpdateProject, R.id.goToTasksList})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_goToUpdateProject:
                getFragmentManager().beginTransaction().replace(R.id.container, new ProjectUpdateFragment()).addToBackStack("null").commit();
                break;
            case R.id.goToTasksList:
                if(BuildConfig.FLAVOR.equalsIgnoreCase("user")){
                    Bundle bundle = new Bundle();
                    ViewTaskListByIDFragment viewTaskListByIDFragment = new ViewTaskListByIDFragment();
                    bundle.putString("index",sharedPreferences.getString("projectId",null));
                    viewTaskListByIDFragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.container, viewTaskListByIDFragment).addToBackStack("null").commit();
                }
                else{
                getFragmentManager().beginTransaction().replace(R.id.container, new TaskListFragment()).addToBackStack("null").commit();}
                break;
        }
    }

    @OnClick(R.id.btn_createTeam)
    public void onViewClicked() {
        String projectId = getArguments().getString("projectId");
        Bundle bundle = new Bundle();
        bundle.putString("projectId", projectId);
        CreateTeamFragment createTeamFragment =  new CreateTeamFragment();
        createTeamFragment.setArguments(bundle);
        getFragmentManager().beginTransaction()
                .replace(R.id.container, createTeamFragment).addToBackStack("null").commit();
    }
}
