package com.tugcenurdaglar.filmleruygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetayActivity extends AppCompatActivity {
    private ImageView imageViewResimDetay;
    private TextView textViewFilmAdDetay, textViewYilDetay, textViewYonetmenDetay;

    private Filmler film;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);

        imageViewResimDetay = findViewById(R.id.imageViewResimDetay);
        textViewFilmAdDetay = findViewById(R.id.textViewFilmAdDetay);
        textViewYilDetay = findViewById(R.id.textViewYilDetay);
        textViewYonetmenDetay = findViewById(R.id.textViewYonetmenDetay);

        film = (Filmler) getIntent().getSerializableExtra("nesne");

        textViewFilmAdDetay.setText(film.getFilm_ad());
        textViewYilDetay.setText(String.valueOf(film.getFilm_yil()));
        textViewYonetmenDetay.setText(film.getYonetmen().getYonetmen_ad());

        imageViewResimDetay.setImageResource(getResources().getIdentifier(film.getFilm_resim(),
                "drawable",
                getPackageName()));
    }
}