package com.example.sande.projectmanagementpersonal.login;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.sande.projectmanagementpersonal.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class StartFragment extends Fragment {


    @BindView(R.id.btn_SignIn_SA)
    Button btnSignInSA;
    @BindView(R.id.btn_Login_SA)
    Button btnLoginSA;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_start, container, false);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.btn_SignIn_SA, R.id.btn_Login_SA})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_SignIn_SA:
                getFragmentManager().beginTransaction().replace(R.id.id_LoginActivity, new RegisterFragment()).addToBackStack("null").commit();
                break;
            case R.id.btn_Login_SA:
                getFragmentManager().beginTransaction().replace(R.id.id_LoginActivity, new LoginFragment()).addToBackStack("null").commit();
                break;
        }
    }
}
