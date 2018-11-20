package com.example.sande.projectmanagementpersonal.project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sande.projectmanagementpersonal.MyApplication;
import com.example.sande.projectmanagementpersonal.R;
import com.example.sande.projectmanagementpersonal.adapters.ProjectListAdapter;
import com.example.sande.projectmanagementpersonal.di.MyComponent;
import com.example.sande.projectmanagementpersonal.network.ApiService;
import com.example.sande.projectmanagementpersonal.pojo.ProjectListPOJO;
import com.example.sande.projectmanagementpersonal.responses.ProjectListResponse;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

import static android.content.Context.MODE_PRIVATE;

public class ProjectListFragment extends Fragment {

    @Inject
    SharedPreferences sharedPreferences;
    @Inject
    Retrofit retrofit;


    private ApiService apiService;
    private List<ProjectListPOJO> myList;
    RecyclerView recyclerView;
    ProjectListAdapter adapter;
    private static final String TAG = "ProjectListFragment";
    FloatingActionButton fab;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_project_list,container,false);
        sharedPreferences = getActivity().getSharedPreferences("MyFile",MODE_PRIVATE);

        fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getFragmentManager().beginTransaction().replace(R.id.container, new ProjectCreateFragment()).addToBackStack("null").commit();
            }
        });

        myList = new ArrayList<>();

        recyclerView = view.findViewById(R.id.recyclerView_ProjectList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        apiService = retrofit.create(ApiService.class);
        apiService.getProjectsList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this:: responseResult, this:: errorResult);

        return  view;
    }

    private void responseResult(ProjectListResponse projectListResponse) {
        Log.i(TAG, "responseResult: " + projectListResponse.getProjectListResponse().get(0).getProjectName());

        myList = projectListResponse.getProjectListResponse();
        adapter = new ProjectListAdapter(myList,getActivity());
        recyclerView.setAdapter(adapter);

        adapter.setClickListener(new ProjectListAdapter.ClickListener() {
            @Override
            public void itemClicked(View view, int position) {


                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("projectId",myList.get(position).getProjectId());
                editor.putString("projectName",myList.get(position).getProjectName());
                editor.putString("projectDesc",myList.get(position).getProjectDescription());
                editor.putString("projectStatus",myList.get(position).getProjectStatus());
                editor.putString("projectStartDate",myList.get(position).getProjStartDate());
                editor.putString("projectEndDate",myList.get(position).getProjEndStart());
                editor.commit();

                Bundle bundle = new Bundle();
                bundle.putString("projectId", sharedPreferences.getString("projectId", ""));
                ProjectDetailFragment projectDetailFragment = new ProjectDetailFragment();
                projectDetailFragment.setArguments(bundle);

                getFragmentManager().beginTransaction().replace(R.id.container,
                        projectDetailFragment).addToBackStack("null").commit();
            }
        });
    }

    private void errorResult(Throwable throwable) {
        Log.i(TAG, "errorResult: " + throwable.getMessage());
    }

    @Override
    public void onAttach(Context context) {
       // ((MyApplication) context.getApplicationContext()).getSpComponentInstance().injectRetrofit(this);
        ((MyApplication) context.getApplicationContext()).getComponentInstance().injectRetrofit(this);
        super.onAttach(context);
    }
}
