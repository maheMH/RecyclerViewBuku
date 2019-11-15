package com.summa.summabooks;

//package com.summa.cassandraclarebooks;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

import static java.util.concurrent.ThreadLocalRandom.current;

public class CardViewBukuAdapter extends RecyclerView.Adapter<CardViewBukuAdapter.CardViewHolder> {

    private ArrayList<Buku>listBuku;
    private Context context;
    private Activity activity;

    public CardViewBukuAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Buku> getListBuku() {
        return listBuku;
    }

    public void setListBuku(ArrayList<Buku> listBuku) {
        this.listBuku = listBuku;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_buku, parent, false);
        CardViewHolder viewHolder = new CardViewHolder(view);
        return viewHolder;
        //return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, final int position) {
        final Buku b = getListBuku().get(position);
        Glide.with(context).load(b.getImg()).override(120,125).into(holder.imgBuku);
        holder.judul.setText(b.getJudul());
        holder.author.setText(b.getAuthor());
        holder.series.setText(b.getSeries());
        holder.Buku = b;

        holder.btnReview.setOnClickListener(new View.OnClickListener() {
                  @Override
                public void onClick(View view) {
                  Intent i = new Intent(context,WebViewActivity.class);
               i.putExtra("review", b.getReview());
               context.startActivity(i);
         }
         });

    }


    @Override
    public int getItemCount() {
        return getListBuku().size();
    }

    public void startactivity(Intent intent){

    }

    public class CardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imgBuku;
        TextView judul, author, series;
        Button btnDetail, btnReview;
        Buku Buku;

        public CardViewHolder(View itemView) {
            super(itemView);
            imgBuku = (ImageView)itemView.findViewById(R.id.img_buku);
            judul = (TextView)itemView.findViewById(R.id.judul);
            author = (TextView)itemView.findViewById(R.id.author);
            series = (TextView)itemView.findViewById(R.id.series);
            btnDetail = (Button)itemView.findViewById(R.id.btn_detail);
            btnReview = (Button)itemView.findViewById(R.id.btn_review);
            btnDetail.setOnClickListener(this);
            btnReview.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, DetailBukuActivity.class);
            intent.putExtra("key", Buku);
            context.startActivity(intent);
        }


    }
}
