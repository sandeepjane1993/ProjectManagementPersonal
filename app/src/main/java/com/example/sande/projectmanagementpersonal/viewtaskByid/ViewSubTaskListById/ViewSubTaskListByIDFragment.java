package com.example.sande.projectmanagementpersonal.viewtaskByid.ViewSubTaskListById;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
import com.example.sande.projectmanagementpersonal.viewtaskByid.ViewSubTaskDetailById.ViewSubTaskDetailByIDFragment;
import com.example.sande.projectmanagementpersonal.viewtaskByid.ViewTaskDetailById.ViewTaskDetailByIDFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.content.Context.MODE_PRIVATE;

public class ViewSubTaskListByIDFragment extends Fragment {
    @Inject
    SharedPreferences sharedPreferences;
    @Inject
    Retrofit retrofit;
    List<ViewSubTaskListByIdPojo> mList;
    final static String user_id="15";
    private static final String TAG = "ViewSubTaskListByIDFrag";
    RecyclerView rv;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_subtask_list_by_id,container,false);
        sharedPreferences = getActivity().getSharedPreferences("MyFile", MODE_PRIVATE);
        mList = new ArrayList<>();
        rv=view.findViewById(R.id.rv_view_subtask_list_by_id);
        ApiService apiService = retrofit.create(ApiService.class);

        Log.i(TAG, "onCreateView: "+sharedPreferences.getString("userId",null));
        Call<ViewSubTaskListByIdResponce> call = apiService.get_View_Subtask_list_by_id_response("15",sharedPreferences.getString("taskid",null));

        call.enqueue(new Callback<ViewSubTaskListByIdResponce>() {
            @Override
            public void onResponse(Call<ViewSubTaskListByIdResponce> call, Response<ViewSubTaskListByIdResponce> response) {

                Log.i(TAG, "success");

                ViewSubTaskListByIdResponce viewTaskListByIdResponce = response.body();

                if(viewTaskListByIdResponce.getViewSubTaskListByIdPojos()!=null) {
                    Log.i(TAG, "onResponse: pass");
                    mList = viewTaskListByIdResponce.getViewSubTaskListByIdPojos();

//                tenantRVAdapter = new TenantRVAdapter(mList);
//
//                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//
//                recyclerView.setAdapter(tenantRVAdapter);

                    ViewSubTaskListByidAdapter adapter = new ViewSubTaskListByidAdapter(getActivity(), mList);
                    //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayout.VERTICAL, false);
                    RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
                    rv.setLayoutManager(layoutManager);
                    rv.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                    adapter.setOnItemClickListener(new ViewSubTaskListByidAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(View v, int position) {
                            //
                            //        SPfiles.SetYixin(getContext(), mList.get(position).getProjectid(),mList.get(position).getTaskid(),mList.get(position).getSubtaskid());
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("projectid", mList.get(position).getProjectid());
                            editor.putString("taskid", mList.get(position).getTaskid());
                            editor.putString("subtaskid", mList.get(position).getSubtaskid());
                            editor.commit();


                            getActivity().getSupportFragmentManager()
                                    .beginTransaction()
                                    .replace(R.id.container, new ViewSubTaskDetailByIDFragment()).
                                    addToBackStack(null)
                                    .commit();
                        }
                    });

                }
                else {
                    mList=new ArrayList<>();
                    ViewSubTaskListByidAdapter adapter = new ViewSubTaskListByidAdapter(getActivity(), mList);
                    //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayout.VERTICAL, false);
                    RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
                    rv.setLayoutManager(layoutManager);
                    rv.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<ViewSubTaskListByIdResponce> call, Throwable t) {
                Toast.makeText(getActivity(), t.toString(), Toast.LENGTH_SHORT).show();
                Log.i(TAG, String.valueOf(t));
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        ((MyApplication) context.getApplicationContext()).getComponentInstance().injectRetrofit(this);
        super.onAttach(context);
    }
}
