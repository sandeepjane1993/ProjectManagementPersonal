package com.example.sande.projectmanagementpersonal.viewtaskByid.ViewSubTaskDetailById;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sande.projectmanagementpersonal.MyApplication;
import com.example.sande.projectmanagementpersonal.R;
import com.example.sande.projectmanagementpersonal.network.ApiService;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.content.Context.MODE_PRIVATE;

public class ViewSubTaskDetailByIDFragment extends Fragment {
    @Inject
    SharedPreferences sharedPreferences;
    @Inject
    Retrofit retrofit;
    private static final String TAG = "ViewSubTaskDetailByIDFr";
    RecyclerView rv;



    @BindView(R.id.tv_viewsubtaskbyid_detailitem)
    TextView tvViewsubtaskbyidDetailitem;
    Unbinder unbinder;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_subtask_detail_by_id, container, false);
        sharedPreferences = getActivity().getSharedPreferences("MyFile", MODE_PRIVATE);


        ApiService apiService = retrofit.create(ApiService.class);
        //String id = mySharedPrefences.getSharePreference(this).getString("id", null);
        Call<ViewSubTaskDetailByIdPojo> call = apiService.get_View_Subtask_detail_by_id_response(

                sharedPreferences.getString("taskid", null),
                sharedPreferences.getString("subtaskid", null),
                sharedPreferences.getString("projectid", null)

        );
        call.enqueue(new Callback<ViewSubTaskDetailByIdPojo>() {
            @Override
            public void onResponse(Call<ViewSubTaskDetailByIdPojo> call, Response<ViewSubTaskDetailByIdPojo> response) {

                ViewSubTaskDetailByIdPojo viewTaskDetailByIdPojo = response.body();

                if (viewTaskDetailByIdPojo.getProjectid() != null) {

                    tvViewsubtaskbyidDetailitem.setText(
                            viewTaskDetailByIdPojo.toString()
                    );
                } else {

                    tvViewsubtaskbyidDetailitem.setText("No Task Assigned !");
                    Toast.makeText(getActivity(), " No Task Assigned !", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ViewSubTaskDetailByIdPojo> call, Throwable t) {
                Toast.makeText(getActivity(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }



    @Override
    public void onAttach(Context context) {
        ((MyApplication) context.getApplicationContext()).getComponentInstance().injectRetrofit(this);
        super.onAttach(context);
    }
}
