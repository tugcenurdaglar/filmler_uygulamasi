package com.tugcenurdaglar.filmleruygulamasi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class FilmlerActivity extends AppCompatActivity {
    private Toolbar toolbar2;
    private RecyclerView filmlerRv;

    private ArrayList<Filmler> filmlerArrayList;
    private FilmlerAdapter adapter;

    private Kategoriler kategori;

    private FilmlerDaoInterface filmlerDaoInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filmler);

        toolbar2 = findViewById(R.id.toolbar2);
        filmlerRv = findViewById(R.id.filmlerRv);


        kategori =  (Kategoriler) getIntent().getSerializableExtra("kategori_nesne");

        filmlerDaoInterface = ApiUtils.getFilmlerDaoInterface();

        toolbar2.setTitle(kategori.getKategoriAd());
        setSupportActionBar(toolbar2);



        filmlerRv.setHasFixedSize(true);
        filmlerRv.setLayoutManager(new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL));

        filmlerDaoInterface.tumFilmlerByKategoriID(Integer.parseInt(kategori.getKategoriId())).enqueue(new Callback<FilmCevap>() {
            @Override
            public void onResponse(Call<FilmCevap> call, Response<FilmCevap> response) {

                List<Filmler> filmler = response.body().getFilmler();

                adapter = new FilmlerAdapter(FilmlerActivity.this, filmler);

                filmlerRv.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<FilmCevap> call, Throwable t) {

            }
        });


    }



}