package com.example.ethens.documentmanager.image;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ahmedadeltito.photoeditorsdk.BrushDrawingView;
import com.ahmedadeltito.photoeditorsdk.OnPhotoEditorSDKListener;
import com.ahmedadeltito.photoeditorsdk.PhotoEditorSDK;
import com.ahmedadeltito.photoeditorsdk.ViewType;
import com.example.ethens.documentmanager.BaseActivity;
import com.example.ethens.documentmanager.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by ethens on 20/08/17.
 */
public class PhotoEditorActivity extends BaseActivity
    implements View.OnClickListener, OnPhotoEditorSDKListener {

  private final String TAG = "PhotoEditorActivity";
  private RelativeLayout parentImageRelativeLayout;
  private RecyclerView drawingViewColorPickerRecyclerView;
  private TextView undoTextView, undoTextTextView, doneDrawingTextView, eraseDrawingTextView;
  private View topShadow;
  private RelativeLayout topShadowRelativeLayout;
  private View bottomShadow;
  private RelativeLayout bottomShadowRelativeLayout;
  private ArrayList<Integer> colorPickerColors;
  private int colorCodeTextView = -1;
  private PhotoEditorSDK photoEditorSDK;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setupUI(R.layout.activity_photo_editor,R.id.parent);

  }

  @Override protected void setupViewHolder(View view) {
    String selectedImagePath = getIntent().getStringExtra(
        getApplicationContext().getString(R.string.extra_image_path));
    new PhotoEditorActivityViewHolder(view,selectedImagePath);
  }

  private boolean stringIsNotEmpty(String string) {
    if (string != null && !string.equals("null")) {
      if (!string.trim().equals("")) {
        return true;
      }
    }
    return false;
  }

  private void addText(String text, int colorCodeTextView) {
    photoEditorSDK.addText(text, colorCodeTextView);
  }

  private void clearAllViews() {
    photoEditorSDK.clearAllViews();
  }

  private void undoViews() {
    photoEditorSDK.viewUndo();
  }

  private void eraseDrawing() {
    photoEditorSDK.brushEraser();
  }

  private void openAddTextPopupWindow(String text, int colorCode) {
    colorCodeTextView = colorCode;
    LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    View addTextPopupWindowRootView = inflater.inflate(R.layout.add_text_popup_window, null);
    final EditText addTextEditText =
        addTextPopupWindowRootView.findViewById(R.id.add_text_edit_text);
    TextView addTextDoneTextView = addTextPopupWindowRootView.findViewById(R.id.add_text_done_tv);
    RecyclerView addTextColorPickerRecyclerView =
        addTextPopupWindowRootView.findViewById(R.id.add_text_color_picker_recycler_view);

    LinearLayoutManager
        layoutManager = new LinearLayoutManager(PhotoEditorActivity.this, LinearLayoutManager.HORIZONTAL, false);
    addTextColorPickerRecyclerView.setLayoutManager(layoutManager);
    addTextColorPickerRecyclerView.setHasFixedSize(true);
    ColorPickerAdapter colorPickerAdapter = new ColorPickerAdapter(PhotoEditorActivity.this, colorPickerColors);
    colorPickerAdapter.setOnColorPickerClickListener(new ColorPickerAdapter.OnColorPickerClickListener() {
      @Override
      public void onColorPickerClickListener(int colorCode) {
        addTextEditText.setTextColor(colorCode);
        colorCodeTextView = colorCode;
      }
    });
    addTextColorPickerRecyclerView.setAdapter(colorPickerAdapter);
    if (stringIsNotEmpty(text)) {
      addTextEditText.setText(text);
      addTextEditText.setTextColor(colorCode == -1 ? getResources().getColor(R.color.white) : colorCode);
    }
    final PopupWindow pop = new PopupWindow(PhotoEditorActivity.this);
    pop.setContentView(addTextPopupWindowRootView);
    pop.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
    pop.setHeight(LinearLayout.LayoutParams.MATCH_PARENT);
    pop.setFocusable(true);
    pop.setBackgroundDrawable(null);
    pop.showAtLocation(addTextPopupWindowRootView, Gravity.TOP, 0, 0);
    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    addTextDoneTextView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        addText(addTextEditText.getText().toString(), colorCodeTextView);
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        pop.dismiss();
      }
    });
  }

  private void updateView(int visibility) {
    topShadow.setVisibility(visibility);
    topShadowRelativeLayout.setVisibility(visibility);
    bottomShadow.setVisibility(visibility);
    bottomShadowRelativeLayout.setVisibility(visibility);
  }

  private void updateBrushDrawingView(boolean brushDrawingMode) {
    photoEditorSDK.setBrushDrawingMode(brushDrawingMode);
    if (brushDrawingMode) {
      updateView(View.GONE);
      drawingViewColorPickerRecyclerView.setVisibility(View.VISIBLE);
      doneDrawingTextView.setVisibility(View.VISIBLE);
      eraseDrawingTextView.setVisibility(View.VISIBLE);
      LinearLayoutManager layoutManager = new LinearLayoutManager(PhotoEditorActivity.this, LinearLayoutManager.HORIZONTAL, false);
      drawingViewColorPickerRecyclerView.setLayoutManager(layoutManager);
      drawingViewColorPickerRecyclerView.setHasFixedSize(true);
      ColorPickerAdapter colorPickerAdapter = new ColorPickerAdapter(PhotoEditorActivity.this, colorPickerColors);
      colorPickerAdapter.setOnColorPickerClickListener(new ColorPickerAdapter.OnColorPickerClickListener() {
        @Override
        public void onColorPickerClickListener(int colorCode) {
          photoEditorSDK.setBrushColor(colorCode);
        }
      });
      drawingViewColorPickerRecyclerView.setAdapter(colorPickerAdapter);
    } else {
      updateView(View.VISIBLE);
      drawingViewColorPickerRecyclerView.setVisibility(View.GONE);
      doneDrawingTextView.setVisibility(View.GONE);
      eraseDrawingTextView.setVisibility(View.GONE);
    }
  }

  private void returnBackWithSavedImage() {
    updateView(View.GONE);
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
        RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
    layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
    parentImageRelativeLayout.setLayoutParams(layoutParams);
    new CountDownTimer(1000, 500) {
      public void onTick(long millisUntilFinished) {

      }

      public void onFinish() {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageName = "IMG_" + timeStamp + ".jpg";
        Intent returnIntent = new Intent();
        returnIntent.putExtra("imagePath", photoEditorSDK.saveImage("PhotoEditorSDK", imageName));
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
      }
    }.start();
  }

  @Override
  public void onEditTextChangeListener(String text, int colorCode) {
    openAddTextPopupWindow(text, colorCode);
  }

  @Override
  public void onAddViewListener(ViewType viewType, int numberOfAddedViews) {
    if (numberOfAddedViews > 0) {
      undoTextView.setVisibility(View.VISIBLE);
      undoTextTextView.setVisibility(View.VISIBLE);
    }
    switch (viewType) {
      case BRUSH_DRAWING:
        Log.i("BRUSH_DRAWING", "onAddViewListener");
        break;
      case EMOJI:
        Log.i("EMOJI", "onAddViewListener");
        break;
      case IMAGE:
        Log.i("IMAGE", "onAddViewListener");
        break;
      case TEXT:
        Log.i("TEXT", "onAddViewListener");
        break;
    }
  }

  @Override
  public void onRemoveViewListener(int numberOfAddedViews) {
    Log.i(TAG, "onRemoveViewListener");
    if (numberOfAddedViews == 0) {
      undoTextView.setVisibility(View.GONE);
      undoTextTextView.setVisibility(View.GONE);
    }
  }

  @Override
  public void onStartViewChangeListener(ViewType viewType) {
    switch (viewType) {
      case BRUSH_DRAWING:
        Log.i("BRUSH_DRAWING", "onStartViewChangeListener");
        break;
      case EMOJI:
        Log.i("EMOJI", "onStartViewChangeListener");
        break;
      case IMAGE:
        Log.i("IMAGE", "onStartViewChangeListener");
        break;
      case TEXT:
        Log.i("TEXT", "onStartViewChangeListener");
        break;
    }
  }

  @Override
  public void onStopViewChangeListener(ViewType viewType) {
    switch (viewType) {
      case BRUSH_DRAWING:
        Log.i("BRUSH_DRAWING", "onStopViewChangeListener");
        break;
      case EMOJI:
        Log.i("EMOJI", "onStopViewChangeListener");
        break;
      case IMAGE:
        Log.i("IMAGE", "onStopViewChangeListener");
        break;
      case TEXT:
        Log.i("TEXT", "onStopViewChangeListener");
        break;
    }
  }

}

