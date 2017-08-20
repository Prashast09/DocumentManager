package com.example.ethens.documentmanager.common.application;

import android.app.Application;

import com.example.ethens.documentmanager.common.di.ComponentFactory;

/**
 * Created by ethens on 19/08/17.
 */

public class DocumentManagerApplication extends Application{

    private ComponentFactory componentFactory;

    @Override public void onCreate() {
        super.onCreate();
        ComponentFactory.getInstance().initializeComponent(this);
    }
}
