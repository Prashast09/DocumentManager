package com.example.ethens.documentmanager.documentfolder.di;

import com.example.ethens.documentmanager.documentfolder.activity.DocumentFolderViewHolder;

import dagger.Subcomponent;

/**
 * Created by ethens on 19/08/17.
 */
@DocumentFolderScope @Subcomponent(modules = DocumentFolderModule.class)
public interface DocumentFolderComponent {

    void inject(DocumentFolderViewHolder documentFolderViewHolder);
}
