package com.tecmilenio.galeriafotos.models;

import com.tecmilenio.galeriafotos.R;

import java.util.ArrayList;
import java.util.List;

public class PhotoRepository {

    private static PhotoRepository instance;
    private List<Photo> photoList;

    private PhotoRepository() {
        photoList = new ArrayList<>();
        photoList.add(new Photo(R.drawable.foto1, "Atardecer", "Un hermoso atardecer en la playa"));
        photoList.add(new Photo(R.drawable.foto2, "Montañas", "Paisaje natural con montañas nevadas"));
        photoList.add(new Photo(R.drawable.foto3, "Ciudad", "Luces de la ciudad de noche"));
        photoList.add(new Photo(R.drawable.foto4, "Bosque", "Sendero en un bosque verde y frondoso"));
    }

    public static PhotoRepository getInstance() {
        if (instance == null) {
            instance = new PhotoRepository();
        }
        return instance;
    }

    public List<Photo> getPhotoList() {
        return photoList;
    }
}
