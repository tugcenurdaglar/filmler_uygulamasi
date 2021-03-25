package com.tugcenurdaglar.filmleruygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

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

        textViewFilmAdDetay.setText(film.getFilmAd());
        textViewYilDetay.setText(String.valueOf(film.getFilmYil()));
        textViewYonetmenDetay.setText(film.getYonetmen().getYonetmenAd());

        String url = "http://kasimadalan.pe.hu/filmler/resimler/"+film.getFilmResim();

        Picasso.get().load(url).resize(400,600).into(imageViewResimDetay);


    }
}