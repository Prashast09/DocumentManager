package com.example.ethens.documentmanager.common.di;

import com.example.ethens.documentmanager.BaseActivity;
import com.example.ethens.documentmanager.common.application.DocumentManagerApplication;
import com.example.ethens.documentmanager.common.database.DatabaseModule;
import com.example.ethens.documentmanager.dashboard.di.DashboardComponent;
import com.example.ethens.documentmanager.dashboard.di.DashboardModule;
import com.example.ethens.documentmanager.documentfolder.activity.DocumentFolderActivity;
import com.example.ethens.documentmanager.documentfolder.di.DocumentFolderComponent;

/**
 * Created by ethens on 19/08/17.
 */

public class ComponentFactory {

    public static ComponentFactory componentFactory;
    public ApplicationComponent applicationComponent;
    public DashboardComponent dashboardComponent;
    public DocumentFolderComponent documentFolderComponent;

    //Private empty constructor
    protected ComponentFactory() {
    }

    //Factory Initializer
    public static ComponentFactory getInstance() {
        if (componentFactory == null) {
            componentFactory = new ComponentFactory();
        }
        return componentFactory;
    }

    public ComponentFactory initializeComponent(DocumentManagerApplication documentManagerApplication) {
       applicationComponent=  DaggerApplicationComponent.builder()
                // This also corresponds to the name of your module: %component_name%Module
                .appModule(new AppModule(documentManagerApplication)).build();
        return componentFactory;
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent ;
    }

    //for dashboard activity
    public DashboardComponent getDashboardComponent(BaseActivity baseActivity) {
        if (dashboardComponent == null) {
            dashboardComponent = getApplicationComponent().plus(new DashboardModule(baseActivity), new DatabaseModule());
        }
        return dashboardComponent;
    }

    public DashboardComponent getDashboardComponent() {
        return dashboardComponent;
    }


    public void removeDashboardComponent() {
        dashboardComponent = null;
    }

    //Document Folder Component

    public DocumentFolderComponent getDocumentFolderComponent(DocumentFolderActivity documentFolderActivity){
        if(documentFolderComponent == null){
            documentFolderComponent = getDashboardComponent().plus(new DashboardModule(documentFolderActivity));
        }
        return documentFolderComponent;

    }

    public DocumentFolderComponent getDocumentFolderComponent(){
        return documentFolderComponent;
    }

    public void removeDocumentFolderComponent(){
        documentFolderComponent = null;
    }

}
