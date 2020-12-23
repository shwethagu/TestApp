package com.demo.testapp.Model;

import android.graphics.Bitmap;

public class ItemModel {

    String label;
    String description;
    Bitmap image;

    public ItemModel(String label, String description, Bitmap image) {
        this.label = label;
        this.description = description;
        this.image = image;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "ItemModel{" +
                "label='" + label + '\'' +
                ", description='" + description + '\'' +
                ", image=" + image +
                '}';
    }
}
