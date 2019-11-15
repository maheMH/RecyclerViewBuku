package com.summa.summabooks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class DetailBukuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_buku);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Buku smhere = getIntent().getParcelableExtra("key");

        ImageView dtimgBuku = (ImageView)findViewById(R.id.dtimg_buku);
        TextView dtjudul = (TextView)findViewById(R.id.dtjudul);
        TextView dtauthor = (TextView)findViewById(R.id.dtauthor);
        TextView dtseries = (TextView)findViewById(R.id.dtseries);
        TextView isbn = (TextView)findViewById(R.id.isbn);
        TextView penerbit = (TextView)findViewById(R.id.penerbit);
        TextView tglTerbit = (TextView)findViewById(R.id.tgl_terbit);
        TextView sinopsis = (TextView)findViewById(R.id.sinopsis);

        Button btnRead = (Button) findViewById(R.id.btn_read);

        Glide.with(this).load(smhere.getImg()).override(120,125).into(dtimgBuku);
        dtjudul.setText(smhere.getJudul());
        dtauthor.setText(smhere.getAuthor());
        dtseries.setText(smhere.getSeries());
        isbn.setText(smhere.getIsbn());
        penerbit.setText(smhere.getPenerbit());
        tglTerbit.setText(smhere.getTglTerbit());
        sinopsis.setText(smhere.getSinopsis());

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                baca();

            }
        });


        Log.i("img", smhere.getImg());
        Log.i("sinopsis", smhere.getSinopsis());
    }

    private void baca() {
        Toast.makeText(this,"You choose this book to read",Toast.LENGTH_SHORT).show();
    }
}
