package com.example.ethens.documentmanager.documentfolder.activity;

import android.view.View;
import com.example.ethens.documentmanager.common.di.ComponentFactory;

/**
 * Created by ethens on 19/08/17.
 */

public class DocumentFolderViewHolder {

    DocumentFolderViewHolder(View view){
        ComponentFactory.getInstance().getDocumentFolderComponent().inject(this);
    }
}
