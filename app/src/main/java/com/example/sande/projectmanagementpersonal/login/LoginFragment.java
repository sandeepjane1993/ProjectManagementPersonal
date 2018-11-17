package com.example.sande.projectmanagementpersonal.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.TextView;
import android.widget.Toast;

import com.example.sande.projectmanagementpersonal.HomePageActivity;
import com.example.sande.projectmanagementpersonal.MyApplication;
import com.example.sande.projectmanagementpersonal.R;
import com.example.sande.projectmanagementpersonal.network.ApiService;
import com.example.sande.projectmanagementpersonal.network.RetrofitInstance;
import com.example.sande.projectmanagementpersonal.pojo.LoginPOJO;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static android.content.Context.MODE_PRIVATE;

public class LoginFragment extends Fragment {

    @Inject
    SharedPreferences sharedPreferences;

    @BindView(R.id.et_email_LI)
    TextInputEditText etEmailLI;
    @BindView(R.id.et_password_SI)
    TextInputEditText etPasswordSI;
    @BindView(R.id.btn_SignIn_SI)
    Button btnSignInSI;
    @BindView(R.id.btn_SignIn_Google)
    Button btnSignInGoogle;
    @BindView(R.id.btn_SignIn_office365)
    Button btnSignInOffice365;
    Unbinder unbinder;
    @BindView(R.id.tv_forgotPassword)
    TextView tvForgotPassword;

    String userRole;

    private static final String TAG = "LoginFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login, container, false);

        sharedPreferences = getActivity().getSharedPreferences("MyFile", MODE_PRIVATE);

        unbinder = ButterKnife.bind(this, view);

        tvForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.id_LoginActivity, new ForgotPasswordFragment()).addToBackStack("null").commit();
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btn_SignIn_SI)
    public void onViewClicked() {

        String email = etEmailLI.getText().toString();
        String password = etPasswordSI.getText().toString();

        ApiService apiService = RetrofitInstance.getRetrofitJsonInstance().create(ApiService.class);
        apiService.login(email, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResults, this::handleError);


    }

    private void handleResults(LoginPOJO loginPOJO) {

        Log.i(TAG, "handleResults: " + loginPOJO.toString());

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("userId", loginPOJO.getUserId());
        editor.putString("userFirstName", loginPOJO.getUserFN());
        editor.putString("userLastName", loginPOJO.getUserLN());
        editor.putString("userEmail", loginPOJO.getUserEmail());
        editor.putString("apiKey", loginPOJO.getApiKey());
        editor.putString("userRole", loginPOJO.getRole());
        editor.commit();
        Log.i(TAG, "handleResults: " + sharedPreferences.getString("userRole",null));

        if (!loginPOJO.getRole().equals("user"))
        {
            startActivity(new Intent(getActivity(),HomePageActivity.class));
        }
        else {
            Toast.makeText(getActivity(), "wrong MANAGER details", Toast.LENGTH_SHORT).show();
        }
    }


    private void handleError(Throwable throwable) {

        Log.i(TAG, "handleError: " + throwable.getMessage());
    }

    @Override
    public void onAttach(Context context) {
        ((MyApplication) context.getApplicationContext()).getComponentInstance().injectRetrofit(this);
        super.onAttach(context);
    }
}
