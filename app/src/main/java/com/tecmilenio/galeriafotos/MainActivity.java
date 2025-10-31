package com.tecmilenio.galeriafotos;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.tecmilenio.galeriafotos.adapters.PhotoPagerAdapter;
import com.tecmilenio.galeriafotos.models.Photo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private Button btnPrev, btnNext, btnGallery;
    private PhotoPagerAdapter adapter;
    private List<Photo> photoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        btnPrev = findViewById(R.id.btnPrev);
        btnNext = findViewById(R.id.btnNext);
        btnGallery = findViewById(R.id.btnGallery);

        photoList = new ArrayList<>();
        photoList.add(new Photo(R.drawable.foto1, "Atardecer", "Un hermoso atardecer en la playa"));
        photoList.add(new Photo(R.drawable.foto2, "Montañas", "Paisaje natural con montañas nevadas"));
        photoList.add(new Photo(R.drawable.foto3, "Ciudad", "Luces de la ciudad de noche"));
        photoList.add(new Photo(R.drawable.foto4, "Bosque", "Sendero en un bosque verde y frondoso"));

        adapter = new PhotoPagerAdapter(this, photoList);
        viewPager.setAdapter(adapter);

        int posicionInicial = getIntent().getIntExtra("posicion_inicial", 0);
        viewPager.setCurrentItem(posicionInicial, false);

        btnPrev.setOnClickListener(v -> {
            int current = viewPager.getCurrentItem();
            if (current > 0) viewPager.setCurrentItem(current - 1);
        });

        btnNext.setOnClickListener(v -> {
            int current = viewPager.getCurrentItem();
            if (current < adapter.getItemCount() - 1) viewPager.setCurrentItem(current + 1);
        });

        btnGallery.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, GalleryActivity.class);
            startActivity(intent);
        });
    }
}
