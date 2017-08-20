package com.example.ethens.documentmanager.documentfolder.config;

import android.graphics.Bitmap;

/**
 * Created by ethens on 19/08/17.
 */

public class ImageConfig {

  Bitmap image;
  String imageUrl;
  String note;
  String id;

  public String getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(String timeStamp) {
    this.timeStamp = timeStamp;
  }

  String timeStamp;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Bitmap getImage() {
    return image;
  }

  public void setImage(Bitmap image) {
    this.image = image;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }
}
