package com.example.ethens.documentmanager.documentfolder.activity;

import android.view.View;

import com.example.ethens.documentmanager.BaseActivity;
import com.example.ethens.documentmanager.R;
import com.example.ethens.documentmanager.common.di.ComponentFactory;

/**
 * Created by ethens on 19/08/17.
 */

public class DocumentFolderActivity extends BaseActivity {

    @Override
    public void setupComponent() {
        super.setupComponent();
        ComponentFactory.getInstance().getDashboardComponent(this).inject(this);
        setupUI(R.id.);
    }

    @Override
    protected void setupViewHolder(View view) {

    }
}
