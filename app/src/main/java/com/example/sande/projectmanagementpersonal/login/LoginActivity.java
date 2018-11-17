package com.example.sande.projectmanagementpersonal.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sande.projectmanagementpersonal.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportFragmentManager().beginTransaction().replace(R.id.id_LoginActivity, new StartFragment()).commit();
    }
}
