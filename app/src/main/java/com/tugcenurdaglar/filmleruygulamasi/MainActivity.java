package com.tugcenurdaglar.filmleruygulamasi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView kategoriRv;

    private ArrayList<Kategoriler> kategorilerArrayList;
    private KategoriAdapter adapter;

    private Veritabani vt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        kategoriRv = findViewById(R.id.kategoriRv);

        veritabaniKopyala();//emulator açılır açılmaz çekilen veriler görülür

        vt  =new Veritabani(this);

        toolbar.setTitle("Kategoriler");
        setSupportActionBar(toolbar);

        kategoriRv.setHasFixedSize(true);
        kategoriRv.setLayoutManager(new LinearLayoutManager(this));

        kategorilerArrayList = new KategoriDao().tumKategoriler(vt);

        adapter = new KategoriAdapter(this,kategorilerArrayList);
        kategoriRv.setAdapter(adapter);

    }

    public void veritabaniKopyala(){ //verilerimizi çekmek için oluşturduk
        DatabaseCopyHelper helper = new DatabaseCopyHelper(this);

        try {
            helper.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }

        helper.openDataBase();
    }

}