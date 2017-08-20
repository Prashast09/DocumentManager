package com.example.ethens.documentmanager.dashboard.di;

import com.example.ethens.documentmanager.BaseActivity;
import com.example.ethens.documentmanager.common.database.DatabaseModule;
import com.example.ethens.documentmanager.documentfolder.di.DocumentFolderComponent;

import dagger.Subcomponent;

/**
 * Created by ethens on 19/08/17.
 */
@Subcomponent(modules = {DashboardModule.class, DatabaseModule.class})
@DashboardScope
public interface DashboardComponent {
    void inject(BaseActivity baseActivity);

    DocumentFolderComponent plus(DashboardModule dashboardModule);
}
