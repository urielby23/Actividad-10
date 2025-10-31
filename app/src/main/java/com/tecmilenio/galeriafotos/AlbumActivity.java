package com.tecmilenio.galeriafotos;

import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.tecmilenio.galeriafotos.adapters.PhotoGridAdapter;
import com.tecmilenio.galeriafotos.models.Photo;
import com.tecmilenio.galeriafotos.models.PhotoRepository;

import java.util.ArrayList;
import java.util.List;

public class AlbumActivity extends AppCompatActivity {

    private GridView gridViewAlbum;
    private List<Photo> allPhotos;
    private List<Photo> albumPhotos;
    private PhotoGridAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        gridViewAlbum = findViewById(R.id.gridViewAlbum);

        String albumName = getIntent().getStringExtra("album_name");

        allPhotos = PhotoRepository.getInstance().getPhotoList(); // ejemplo de singleton

        albumPhotos = new ArrayList<>();
        for (Photo photo : allPhotos) {
            if (photo.getAlbum().equals(albumName)) {
                albumPhotos.add(photo);
            }
        }

        adapter = new PhotoGridAdapter(this, albumPhotos);
        gridViewAlbum.setAdapter(adapter);
    }
}
