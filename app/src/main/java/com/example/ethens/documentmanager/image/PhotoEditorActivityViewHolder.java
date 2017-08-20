package com.example.ethens.documentmanager.image;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ahmedadeltito.photoeditorsdk.BrushDrawingView;
import com.example.ethens.documentmanager.R;
import java.util.ArrayList;
import javax.inject.Inject;

/**
 * Created by ethens on 20/08/17.
 */

public class PhotoEditorActivityViewHolder implements View.OnClickListener {

  @Inject Context context;
  private RelativeLayout parentImageRelativeLayout;
  private RecyclerView drawingViewColorPickerRecyclerView;
  private TextView undoTextView, undoTextTextView, doneDrawingTextView, eraseDrawingTextView;

  private View topShadow;
  private RelativeLayout topShadowRelativeLayout;
  private View bottomShadow;
  private RelativeLayout bottomShadowRelativeLayout,deleteRelativeLayout;
  private TextView addTextView, addPencil, deleteTextView, saveTextView,
      clearAllTextView, clearAllTextTextView, goToNextTextView,closeTextView,saveTextTextView;
  private ImageView photoEditImageView;

  private ArrayList<Integer> colorPickerColors;


  PhotoEditorActivityViewHolder(View view, String selectedImagePath) {
    BrushDrawingView brushDrawingView = view.findViewById(R.id.drawing_view);

    drawingViewColorPickerRecyclerView =
        view.findViewById(R.id.drawing_view_color_picker_recycler_view);
    parentImageRelativeLayout = view.findViewById(R.id.parent_image_rl);

    closeTextView = view.findViewById(R.id.close_tv);
    addTextView = view.findViewById(R.id.add_text_tv);
    addPencil = view.findViewById(R.id.add_pencil_tv);
    deleteRelativeLayout = view.findViewById(R.id.delete_rl);
    deleteTextView = view.findViewById(R.id.delete_tv);
    saveTextView = view.findViewById(R.id.save_tv);
    saveTextTextView = view.findViewById(R.id.save_text_tv);
    undoTextView = view.findViewById(R.id.undo_tv);
    undoTextTextView = view.findViewById(R.id.undo_text_tv);
    doneDrawingTextView = view.findViewById(R.id.done_drawing_tv);
    eraseDrawingTextView = view.findViewById(R.id.erase_drawing_tv);
    clearAllTextView = view.findViewById(R.id.clear_all_tv);
    clearAllTextTextView = view.findViewById(R.id.clear_all_text_tv);
    goToNextTextView = view.findViewById(R.id.go_to_next_screen_tv);
    photoEditImageView = view.findViewById(R.id.photo_edit_iv);


    setFont();
    setColors();
    setListeners();
  }

  @Override
  public void onClick(View v) {
    if (v.getId() == R.id.close_tv) {

    } else if (v.getId() == R.id.add_text_tv) {

    } else if (v.getId() == R.id.add_pencil_tv) {

    } else if (v.getId() == R.id.done_drawing_tv) {

    } else if (v.getId() == R.id.save_tv || v.getId() == R.id.save_text_tv) {

    } else if (v.getId() == R.id.clear_all_tv || v.getId() == R.id.clear_all_text_tv) {

    } else if (v.getId() == R.id.undo_text_tv || v.getId() == R.id.undo_tv) {

    } else if (v.getId() == R.id.erase_drawing_tv) {

    } else if (v.getId() == R.id.go_to_next_screen_tv) {

    }
  }

  private void setListeners() {
    closeTextView.setOnClickListener(this);
    addTextView.setOnClickListener(this);
    addPencil.setOnClickListener(this);
    saveTextView.setOnClickListener(this);
    saveTextTextView.setOnClickListener(this);
    undoTextView.setOnClickListener(this);
    undoTextTextView.setOnClickListener(this);
    doneDrawingTextView.setOnClickListener(this);
    eraseDrawingTextView.setOnClickListener(this);
    clearAllTextView.setOnClickListener(this);
    clearAllTextTextView.setOnClickListener(this);
    goToNextTextView.setOnClickListener(this);
  }

  private void setFont() {
    Typeface newFont = Typeface.createFromAsset(context.getAssets(), "Eventtus-Icons.ttf");

    closeTextView.setTypeface(newFont);
    addTextView.setTypeface(newFont);
    addPencil.setTypeface(newFont);
    saveTextView.setTypeface(newFont);
    undoTextView.setTypeface(newFont);
    clearAllTextView.setTypeface(newFont);
    goToNextTextView.setTypeface(newFont);
    deleteTextView.setTypeface(newFont);
  }

  private void setColors(){
    colorPickerColors = new ArrayList<>();
    colorPickerColors.add(context.getResources().getColor(R.color.black));
    colorPickerColors.add(context.getResources().getColor(R.color.blue_color_picker));
    colorPickerColors.add(context.getResources().getColor(R.color.brown_color_picker));
    colorPickerColors.add(context.getResources().getColor(R.color.green_color_picker));
    colorPickerColors.add(context.getResources().getColor(R.color.orange_color_picker));
    colorPickerColors.add(context.getResources().getColor(R.color.red_color_picker));
    colorPickerColors.add(context.getResources().getColor(R.color.red_orange_color_picker));
    colorPickerColors.add(context.getResources().getColor(R.color.sky_blue_color_picker));
    colorPickerColors.add(context.getResources().getColor(R.color.violet_color_picker));
    colorPickerColors.add(context.getResources().getColor(R.color.white));
    colorPickerColors.add(context.getResources().getColor(R.color.yellow_color_picker));
    colorPickerColors.add(context.getResources().getColor(R.color.yellow_green_color_picker));

  }
}
