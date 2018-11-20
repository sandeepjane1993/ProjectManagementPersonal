package com.example.sande.projectmanagementpersonal.viewtaskByid.ViewTeamMenberByTask;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.sande.projectmanagementpersonal.MyApplication;
import com.example.sande.projectmanagementpersonal.R;
import com.example.sande.projectmanagementpersonal.network.ApiService;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.content.Context.MODE_PRIVATE;

public class ViewTeamMenberByTask extends Fragment implements TeamMenberListByTaskInterface.FragmentView{
    @Inject
    SharedPreferences sharedPreferences;
    @Inject
    Retrofit retrofit;

    List<TeamMenberListByTaskPojo> mList;
    private static final String TAG = "ViewTeamMenberByTask";
    RecyclerView rv;
    TeamMenberListByTaskPresenter teamMenberListByTaskPresenter;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_team_menber_by_task,container,false);
        rv=view.findViewById(R.id.rv_view_teammeber_by_task);
        teamMenberListByTaskPresenter = new TeamMenberListByTaskPresenter(this);
        teamMenberListByTaskPresenter.initview();
        teamMenberListByTaskPresenter.retrofitcall();

        return view;
    }

    @Override
    public void onAttach(Context context) {
        ((MyApplication) context.getApplicationContext()).getComponentInstance().injectRetrofit(this);
        super.onAttach(context);
    }

    @Override
    public void initview2() {

        sharedPreferences = getActivity().getSharedPreferences("MyFile", MODE_PRIVATE);
        mList = new ArrayList<>();

    }

    @Override
    public void retrofit() {

       // recyclerView.setItemAnimator(new DefaultItemAnimator());

        ApiService apiService = retrofit.create(ApiService.class);
        apiService.getTeamListByTask("1","27")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this:: responseResult, this::errorResult);
    }

    private void errorResult(Throwable throwable) {
        Log.i(TAG, "errorResult: " + throwable.getMessage());
    }

    private void responseResult(TeamMenberListByTaskResponse teamMenberListByTaskResponse) {
        if(teamMenberListByTaskResponse.getTeamMenberListByTaskPojos()!=null) {
            Log.i(TAG, "onResponse: pass");
            mList = teamMenberListByTaskResponse.getTeamMenberListByTaskPojos();

            TeamMenberByListAdapter adapter = new TeamMenberByListAdapter(getActivity(), mList);
            //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayout.VERTICAL, false);
            RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
            rv.setLayoutManager(layoutManager);
            rv.setAdapter(adapter);
            adapter.notifyDataSetChanged();
            adapter.setOnItemClickListener(new TeamMenberByListAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View v, int position) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("memberuserid", mList.get(position).getUserid());
                    editor.commit();
                          /* TODO getActivity().getSupportFragmentManager()
                                    .beginTransaction()
                                    .replace(R.id.container, new ViewSubTaskDetailByIDFragment()).
                                    addToBackStack(null)
                                    .commit();*/
                }
            });

        }
        else {
            mList=new ArrayList<>();
            TeamMenberByListAdapter adapter = new TeamMenberByListAdapter(getActivity(), mList);
            //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayout.VERTICAL, false);
            RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
            rv.setLayoutManager(layoutManager);
            rv.setAdapter(adapter);

        }
    }
}
