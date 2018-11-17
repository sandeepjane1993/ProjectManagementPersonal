package com.example.sande.projectmanagementpersonal.di;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MySharedPreferenceModule {

    private Context context;

    public MySharedPreferenceModule(Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    public Context providesContext()
    {
        return context;
    }

    @Singleton
    @Provides
    public SharedPreferences providesSharedPreferences(Context context)
    {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }
}
