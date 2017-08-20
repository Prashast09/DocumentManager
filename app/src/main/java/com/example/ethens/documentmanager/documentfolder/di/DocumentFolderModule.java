package com.example.ethens.documentmanager.documentfolder.di;

import com.example.ethens.documentmanager.BaseActivity;

import dagger.Module;

/**
 * Created by ethens on 19/08/17.
 */
@Module
public class DocumentFolderModule {
    DocumentFolderModule documentFolderModule;
    public DocumentFolderModule(DocumentFolderModule documentFolderModule){
        this.documentFolderModule = documentFolderModule;
    }


}
