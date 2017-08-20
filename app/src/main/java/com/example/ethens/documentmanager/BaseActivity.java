package com.example.ethens.documentmanager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.ethens.documentmanager.common.di.ComponentFactory;

/**
 * Created by ethens on 19/08/17.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupComponent();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    protected void setupUI(int layoutId, int viewHolderId) {
        setContentView(layoutId);
        setupComponent();
        getIntent();
        setupViewHolder(findViewById(viewHolderId));
    }

    abstract protected void setupViewHolder(View view);

    public void setupComponent() {
        ComponentFactory.getInstance().getDashboardComponent(this).inject(this);
    }


}
