package com.tecmilenio.galeriafotos;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.tecmilenio.galeriafotos.adapters.PhotoGridAdapter;
import com.tecmilenio.galeriafotos.models.Photo;
import com.tecmilenio.galeriafotos.models.PhotoRepository;

import java.util.List;

public class GalleryActivity extends AppCompatActivity {

    private GridView gridView;
    private PhotoGridAdapter adapter;
    private FloatingActionButton fab;
    private List<Photo> photoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        gridView = findViewById(R.id.gridView);
        fab = findViewById(R.id.fabActions);

        photoList = PhotoRepository.getInstance().getPhotoList();

        adapter = new PhotoGridAdapter(this, photoList);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener((parent, view, position, id) -> {
            if (!adapter.getSelectedPositions().isEmpty()) {
                adapter.toggleSelection(position);
                toggleFabVisibility();
            } else {
                Intent intent = new Intent(GalleryActivity.this, MainActivity.class);
                intent.putExtra("posicion_inicial", position);
                startActivity(intent);
            }
        });

        gridView.setOnItemLongClickListener((parent, view, position, id) -> {
            adapter.toggleSelection(position);
            toggleFabVisibility();
            return true;
        });

        fab.setOnClickListener(v -> {
            List<Integer> selected = adapter.getSelectedPositions();
            if (selected.isEmpty()) return;

            String[] options = {"Compartir", "Eliminar", "Organizar"};
            new androidx.appcompat.app.AlertDialog.Builder(this)
                    .setTitle("Acción para fotos seleccionadas")
                    .setItems(options, (dialog, which) -> {
                        switch (which) {
                            case 0: // Compartir
                                for (int i : selected) {
                                    Photo photo = photoList.get(i);
                                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                                    shareIntent.setType("image/*");
                                    shareIntent.putExtra(Intent.EXTRA_STREAM,
                                            Uri.parse("android.resource://" + getPackageName() + "/" + photo.getImageResId()));
                                    shareIntent.putExtra(Intent.EXTRA_TEXT, photo.getTitle() + "\n" + photo.getDescription());
                                    startActivity(Intent.createChooser(shareIntent, "Compartir foto"));
                                }
                                break;
                            case 1: // Eliminar
                                for (int i = selected.size() - 1; i >= 0; i--) {
                                    photoList.remove((int) selected.get(i));
                                }
                                adapter.clearSelection();
                                adapter.notifyDataSetChanged();
                                toggleFabVisibility();
                                break;
                            case 2: // Organizar
                                String[] albums = {"Favoritos", "Vacaciones", "Trabajo"};
                                new androidx.appcompat.app.AlertDialog.Builder(this)
                                        .setTitle("Selecciona un álbum")
                                        .setItems(albums, (dialog1, albumIndex) -> {
                                            String selectedAlbum = albums[albumIndex];
                                            for (int i : selected) {
                                                Photo photo = photoList.get(i);
                                                photo.setAlbum(selectedAlbum);
                                            }
                                            adapter.clearSelection();
                                            adapter.notifyDataSetChanged();
                                            toggleFabVisibility();

                                            new androidx.appcompat.app.AlertDialog.Builder(this)
                                                    .setMessage("¿Deseas abrir el álbum " + selectedAlbum + "?")
                                                    .setPositiveButton("Sí", (d, w) -> {
                                                        Intent intentAlbum = new Intent(GalleryActivity.this, AlbumActivity.class);
                                                        intentAlbum.putExtra("album_name", selectedAlbum);
                                                        startActivity(intentAlbum);
                                                    })
                                                    .setNegativeButton("No", null)
                                                    .show();
                                        }).show();
                                break;
                        }
                    }).show();
        });
    }

    private void toggleFabVisibility() {
        if (adapter.getSelectedPositions().isEmpty()) {
            fab.setVisibility(FloatingActionButton.GONE);
        } else {
            fab.setVisibility(FloatingActionButton.VISIBLE);
        }
    }
}
