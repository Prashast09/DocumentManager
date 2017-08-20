package com.example.ethens.documentmanager.common.di;

/**
 * Root Component
 * Created by ethens on 19/08/17.
 */

import com.example.ethens.documentmanager.common.database.DatabaseModule;
import com.example.ethens.documentmanager.dashboard.di.DashboardComponent;
import com.example.ethens.documentmanager.dashboard.di.DashboardModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton @Component(modules = { AppModule.class }) public interface ApplicationComponent {


    DashboardComponent plus(DashboardModule dashboardModule, DatabaseModule databaseModule);
}
