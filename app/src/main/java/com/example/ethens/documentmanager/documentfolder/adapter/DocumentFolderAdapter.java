package com.example.ethens.documentmanager.documentfolder.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.ethens.documentmanager.R;
import com.example.ethens.documentmanager.documentfolder.config.ImageConfig;
import java.util.List;

/**
 * Created by ethens on 19/08/17.
 */

public class DocumentFolderAdapter extends RecyclerView.Adapter<DocumentFolderAdapter.DocumentFolderAdapterHolder>{


  private List<ImageConfig> mImageConfigs;

  DocumentFolderAdapter(List<ImageConfig> imageConfigList){
    this.mImageConfigs = imageConfigList;
  }

  @Override public DocumentFolderAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    Context context = parent.getContext();
    LayoutInflater inflater = LayoutInflater.from(context);
    View view = inflater.inflate(R.layout.item_folder_image, parent, false);
    return new DocumentFolderAdapterHolder(view);
  }

  @Override public void onBindViewHolder(DocumentFolderAdapterHolder holder, int position) {
    ImageConfig imageConfig= mImageConfigs.get(position);
    holder.setViewsData(imageConfig);
  }

  @Override public int getItemCount() {
    return 0;
  }

  public class DocumentFolderAdapterHolder extends RecyclerView.ViewHolder {

    private ImageView imageView;
    private TextView imageTag;
    private Button viewTagButton;
    private EditText timeStamp, id;

    DocumentFolderAdapterHolder(View view){
      super(view);
      imageView = view.findViewById(R.id.image);
      imageTag = view.findViewById(R.id.image_tag);
      viewTagButton = view.findViewById(R.id.view_tag_button);
      id = view.findViewById(R.id.doc_num);
      timeStamp = view.findViewById(R.id.date_time);
      attachListeners();

    }

    private void attachListeners() {
      viewTagButton.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View view) {
          if(imageTag.getVisibility()== View.GONE){
              imageTag.setVisibility(View.VISIBLE);
              viewTagButton.setText("Click to hide image tag");
          }
          else
            imageTag.setVisibility(View.GONE);
            viewTagButton.setText("Click to view image tag");
        }
      });

      imageView.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View view) {

        }
      });
    }

    private void setViewsData(ImageConfig imageConfig){
      imageView.setImageBitmap(imageConfig.getImage());
      imageTag.setText(imageConfig.getNote());
      id.setText(imageConfig.getId());
      timeStamp.setText(imageConfig.getTimeStamp());
      imageTag.setVisibility(View.GONE);
    }


  }
}
