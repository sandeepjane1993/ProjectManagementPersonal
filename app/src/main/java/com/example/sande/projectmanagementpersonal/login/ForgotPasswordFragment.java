package com.example.sande.projectmanagementpersonal.login;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.sande.projectmanagementpersonal.MyApplication;
import com.example.sande.projectmanagementpersonal.R;
import com.example.sande.projectmanagementpersonal.di.ApiModule;
import com.example.sande.projectmanagementpersonal.di.MyComponent;
import com.example.sande.projectmanagementpersonal.network.ApiService;
import com.example.sande.projectmanagementpersonal.network.RetrofitInstance;
import com.example.sande.projectmanagementpersonal.pojo.ForgotPasswordPOJO;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class ForgotPasswordFragment extends Fragment {

    @Inject
    Retrofit retrofit;

    MyComponent component;
    ApiService apiService;

    @BindView(R.id.et_email_FP)
    TextInputEditText etEmailFP;
    @BindView(R.id.btn_GetPassword_FP)
    Button btnGetPasswordFP;
    Unbinder unbinder;

    private static final String TAG = "ForgotPasswordFragment";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_forgot_password, container, false);

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
        /* component = DaggerMyComponent.builder().apiModule(new ApiModule("http://rjtmobile.com")).build();
        component.injectRetrofit(this);*/
        super.onAttach(context);
    }

    @OnClick(R.id.btn_GetPassword_FP)
    public void onViewClicked() {

        String email = etEmailFP.getText().toString();

        ApiService apiService = retrofit.create(ApiService.class);
        apiService.forgotPassword(email)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResults, this::handleError);
    }

    private void handleResults(ForgotPasswordPOJO forgotPasswordPOJO) {
        Log.i(TAG, "handleResults: " + forgotPasswordPOJO.toString());
    }

    private void handleError(Throwable throwable) {
        Log.i(TAG, "handleError: " + throwable.getMessage());
    }
}
