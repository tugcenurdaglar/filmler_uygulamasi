package com.tugcenurdaglar.filmleruygulamasi;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class KategoriAdapter extends RecyclerView.Adapter<KategoriAdapter.CardTasarimTutucu> {
    private Context mContext;
    private List<Kategoriler> kategorilerListe;

    public KategoriAdapter(Context mContext, List<Kategoriler> kategorilerListe) {
        this.mContext = mContext;
        this.kategorilerListe = kategorilerListe;
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /*kategori card tasarimini al CardTasarimTutucu sınıfının Constructorına gönder
        ki bu sınıfın nesnelerine erişebil
        * */

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kategori_card_tasarim,parent,false);



        return new CardTasarimTutucu(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        final Kategoriler kategori = kategorilerListe.get(position);

        holder.textViewKategoriAd.setText(kategori.getKategori_ad());

        holder.kategori_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,FilmlerActivity.class);
                intent.putExtra("kategori_nesne",kategori);
                mContext.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return kategorilerListe.size();
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        private CardView kategori_card;
        private TextView textViewKategoriAd;

        public CardTasarimTutucu(@NonNull View itemView) {
            super(itemView);
            kategori_card = itemView.findViewById(R.id.kategori_card);
            textViewKategoriAd = itemView.findViewById(R.id.textViewKategoriAd);
        }
        //card tasarımin üzerindeki nesneler burada tutulacak

    }
}
