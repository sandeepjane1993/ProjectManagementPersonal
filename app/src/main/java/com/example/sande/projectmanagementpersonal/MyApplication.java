package com.example.sande.projectmanagementpersonal;

import android.app.Application;

import com.example.sande.projectmanagementpersonal.di.ApiModule;


import com.example.sande.projectmanagementpersonal.di.DaggerMyComponent;
import com.example.sande.projectmanagementpersonal.di.MyComponent;
import com.example.sande.projectmanagementpersonal.di.MySharedPreferenceModule;

public class MyApplication extends Application {


    MyComponent component;
    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerMyComponent.builder()
                .apiModule(new ApiModule("http://rjtmobile.com"))
                .mySharedPreferenceModule(new MySharedPreferenceModule(getApplicationContext()))
                .build();

    }

    public MyComponent getComponentInstance()
    {
        return component;
    }

}
