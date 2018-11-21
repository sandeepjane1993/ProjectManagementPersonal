package com.example.sande.projectmanagementpersonal.tasks;

import android.content.Context;
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
import android.widget.Button;

import com.example.sande.projectmanagementpersonal.BuildConfig;
import com.example.sande.projectmanagementpersonal.MyApplication;
import com.example.sande.projectmanagementpersonal.R;
import com.example.sande.projectmanagementpersonal.adapters.TaskListAdapter;
import com.example.sande.projectmanagementpersonal.network.ApiService;
import com.example.sande.projectmanagementpersonal.pojo.TaskListPOJO;
import com.example.sande.projectmanagementpersonal.responses.TaskListResponse;
import com.example.sande.projectmanagementpersonal.subtask.SubTaskListFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

import static android.content.Context.MODE_PRIVATE;

public class TaskListFragment extends Fragment {

    @Inject
    SharedPreferences sharedPreferences;

    @Inject
    Retrofit retrofit;

    private ApiService apiService;
     private List<TaskListPOJO> myList;
    TaskListAdapter adapter;

    RecyclerView recyclerView;
    @BindView(R.id.fab_taskList)
    FloatingActionButton fabTaskList;
    Unbinder unbinder;

    private static final String TAG = "TaskListFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tasklist, container, false);

         myList = new ArrayList<>();
         recyclerView = view.findViewById(R.id.recyclerView_TaskList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        if(BuildConfig.FLAVOR.equalsIgnoreCase("user")){
            fabTaskList = (FloatingActionButton)view.findViewById(R.id.fab_taskList);
            fabTaskList.hide();

        }
        sharedPreferences = getActivity().getSharedPreferences("MyFile",MODE_PRIVATE);


        apiService = retrofit.create(ApiService.class);
        apiService.getTaskList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::responseResult, this::errorResult);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    private void responseResult(TaskListResponse taskListResponse) {
        Log.i(TAG, "responseResult: " + taskListResponse.getTaskListResponse().get(0).getTaskName());

        myList = taskListResponse.getTaskListResponse();

        adapter = new TaskListAdapter(myList,getActivity());
        recyclerView.setAdapter(adapter);

        adapter.setClickListener(new TaskListAdapter.ClickListener() {
            @Override
            public void itemClicked(View view, int position) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("taskId",myList.get(position).getTaskId());
                editor.putString("taskName",myList.get(position).getTaskName());
                editor.putString("taskDesc",myList.get(position).getTaskDescription());
                editor.putString("taskStatus",myList.get(position).getTaskStatus());
                editor.putString("taskStartDate",myList.get(position).getStartDate());
                editor.putString("taskEndDate",myList.get(position).getEndDate());
                editor.commit();


                Bundle bundle = new Bundle();
                bundle.putString("taskId", myList.get(position).getTaskId() );
                TaskDetailFragment taskDetailFragment= new TaskDetailFragment();
                taskDetailFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.container,
                        taskDetailFragment).addToBackStack("null").commit();
                // fragment transact
         /*       Bundle bundle = new Bundle();
                bundle.putString("taskId", myList.get(position).getTaskId() );
                SubTaskListFragment generalSubTaskFragment= new SubTaskListFragment();
                generalSubTaskFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.container,
                        generalSubTaskFragment).addToBackStack("null").commit();*/
            }
        });
    }

    private void errorResult(Throwable throwable) {
        Log.i(TAG, "errorResult: " + throwable.getMessage());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.fab_taskList)
    public void onViewClicked() {

        getFragmentManager().beginTransaction().replace(R.id.container,new TaskCreateFragment()).addToBackStack("null").commit();

    }

    @Override
    public void onAttach(Context context) {
        ((MyApplication) context.getApplicationContext()).getComponentInstance().injectRetrofit(this);
        super.onAttach(context);
    }
}
