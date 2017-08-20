package com.example.ethens.documentmanager.dashboard.di;

import android.support.v7.app.AppCompatActivity;

import com.example.ethens.documentmanager.BaseActivity;

import dagger.Module;

/**
 * Created by ethens on 19/08/17.
 */
@Module
public class DashboardModule {

    BaseActivity baseActivity;
    
    public DashboardModule(BaseActivity baseActivity){
        this.baseActivity = baseActivity;
    }

}
