package com.tecmilenio.galeriafotos.models;

public class Photo {
    private int imageResId;
    private String title;
    private String description;
    private String album;

    public Photo(int imageResId, String title, String description) {
        this.imageResId = imageResId;
        this.title = title;
        this.description = description;
        this.album = "";
    }

    public Photo(int imageResId, String title, String description, String album) {
        this.imageResId = imageResId;
        this.title = title;
        this.description = description;
        this.album = album;
    }

    public int getImageResId() { return imageResId; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getAlbum() { return album; }
    public void setAlbum(String album) { this.album = album; }
}
