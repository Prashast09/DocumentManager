package com.example.ethens.documentmanager.dashboard.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.ethens.documentmanager.BaseActivity;
import com.example.ethens.documentmanager.common.di.ComponentFactory;

/**
 * Created by ethens on 19/08/17.
 */

public class DashboardActivity extends BaseActivity {

    @Override
    protected void setupViewHolder(View view) {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void setupComponent() {
        super.setupComponent();
        ComponentFactory.getInstance().getDashboardComponent(this).inject(this);
    }
}
