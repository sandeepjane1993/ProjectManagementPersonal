package com.example.sande.projectmanagementpersonal.login;

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

import com.example.sande.projectmanagementpersonal.R;
import com.example.sande.projectmanagementpersonal.network.ApiService;
import com.example.sande.projectmanagementpersonal.network.RetrofitInstance;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RegisterFragment extends Fragment {

    @BindView(R.id.et_firstName_SI)
    TextInputEditText etFirstNameSI;
    @BindView(R.id.et_lastName_SI)
    TextInputEditText etLastNameSI;
    @BindView(R.id.et_email_SI)
    TextInputEditText etEmailSI;
    @BindView(R.id.et_mobile_SI)
    TextInputEditText etMobileSI;
    @BindView(R.id.et_password_SI)
    TextInputEditText etPasswordSI;
    @BindView(R.id.et_companySize_SI)
    TextInputEditText etCompanySizeSI;
    @BindView(R.id.et_Role_SI)
    TextInputEditText etRoleSI;
    @BindView(R.id.btn_SignIn_SI)
    Button btnSignInSI;
    Unbinder unbinder;

    private static final String TAG = "RegisterFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_signin, container, false);

        unbinder = ButterKnife.bind(this, view);


        return view;
    }


    private void handleError(Throwable throwable) {

        Log.i(TAG, "handleError: " + throwable.getMessage());
    }

    private void handleResults(String s) {
        Log.i(TAG, "handleResults: " + s);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btn_SignIn_SI)
    public void onViewClicked() {

        String fN = etFirstNameSI.getText().toString();
        String lN = etLastNameSI.getText().toString();
        String email = etEmailSI.getText().toString();
        String mobile = etMobileSI.getText().toString();
        String password = etPasswordSI.getText().toString();
        String cs = etCompanySizeSI.getText().toString();
        String role = etRoleSI.getText().toString();


        ApiService apiService = RetrofitInstance.getRetrofitStringInstance().create(ApiService.class);
        apiService.register(fN, lN, email, mobile, password, cs, role)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResults, this::handleError);
    }
}
