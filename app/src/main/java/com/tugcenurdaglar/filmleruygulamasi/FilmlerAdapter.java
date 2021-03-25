package com.tugcenurdaglar.filmleruygulamasi;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class FilmlerAdapter extends RecyclerView.Adapter<FilmlerAdapter.CardTasarimTutucu> {
    private Context mContext;
    private List<Filmler> filmlerListe;

    public FilmlerAdapter(Context mContext, List<Filmler> filmlerListe) {
        this.mContext = mContext;
        this.filmlerListe = filmlerListe;
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /*kategori card tasarimini al CardTasarimTutucu sınıfının Constructorına gönder
        ki bu sınıfın nesnelerine erişebil
        * */

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.film_card_tasarim,parent,false);



        return new CardTasarimTutucu(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        Filmler film = filmlerListe.get(position);

        holder.textViewFilmAd.setText(film.getFilmAd());

        String url = "http://kasimadalan.pe.hu/filmler/resimler/"+film.getFilmResim();

        Picasso.get().load(url).into(holder.imageViewFilmResim);

        holder.film_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,DetayActivity.class);
                intent.putExtra("nesne", film);
                mContext.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return filmlerListe.size();
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        private CardView film_card;
        private TextView textViewFilmAd;
        private ImageView imageViewFilmResim;

        public CardTasarimTutucu(@NonNull View itemView) {
            super(itemView);
            film_card = itemView.findViewById(R.id.film_card);
            textViewFilmAd = itemView.findViewById(R.id.textViewFilmAd);
            imageViewFilmResim= itemView.findViewById(R.id.imageViewFilmResim);
        }
        //card tasarımin üzerindeki nesneler burada tutulacak

    }
}
