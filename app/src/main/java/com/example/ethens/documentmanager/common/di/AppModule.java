package com.example.ethens.documentmanager.common.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.ethens.documentmanager.common.application.DocumentManagerApplication;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ethens on 19/08/17.
 */
@Module
public class AppModule {

    protected DocumentManagerApplication mDocumentManagerApplication;

    public AppModule(DocumentManagerApplication documentManagerApplication) {
        mDocumentManagerApplication = documentManagerApplication;
    }

    @Provides @Singleton
    DocumentManagerApplication providesDocumentManagerApplication() {
        return mDocumentManagerApplication;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return mDocumentManagerApplication;
    }

    @Provides @Singleton
    SharedPreferences providesSharedPrefs() {
        return PreferenceManager.getDefaultSharedPreferences(mDocumentManagerApplication);
    }

    @Provides @Singleton
    Context providesContext() {
        return mDocumentManagerApplication;
    }
}
