package com.tecmilenio.galeriafotos.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.tecmilenio.galeriafotos.models.Photo;

import java.util.ArrayList;
import java.util.List;

public class PhotoGridAdapter extends BaseAdapter {

    private Context context;
    private List<Photo> photos;
    private List<Integer> selectedPositions;

    public PhotoGridAdapter(Context context, List<Photo> photos) {
        this.context = context;
        this.photos = photos;
        this.selectedPositions = new ArrayList<>();
    }

    @Override
    public int getCount() { return photos.size(); }

    @Override
    public Object getItem(int position) { return photos.get(position); }

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(context);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(400, 400));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(photos.get(position).getImageResId());

        if (selectedPositions.contains(position)) {
            imageView.setBackgroundColor(Color.parseColor("#AA2196F3")); // azul semitransparente
        } else {
            imageView.setBackgroundColor(Color.TRANSPARENT);
        }

        return imageView;
    }

    public void toggleSelection(int position) {
        if (selectedPositions.contains(position)) {
            selectedPositions.remove((Integer) position);
        } else {
            selectedPositions.add(position);
        }
        notifyDataSetChanged();
    }

    public List<Integer> getSelectedPositions() { return selectedPositions; }

    public void clearSelection() {
        selectedPositions.clear();
        notifyDataSetChanged();
    }
}
