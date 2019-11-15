package com.summa.summabooks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView listBuku;
    private ArrayList<Buku> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listBuku = (RecyclerView)findViewById(R.id.listbuku);
        listBuku.setHasFixedSize(true);

        list = new ArrayList<>();
        list.addAll(dataBuku.getListData());
        showRecylerCardView();

    }

    private void showRecylerCardView() {
        listBuku.setLayoutManager(new LinearLayoutManager(this));
        CardViewBukuAdapter cardViewPresidentAdapter= new CardViewBukuAdapter(this);
        cardViewPresidentAdapter.setListBuku(list);
        listBuku.setAdapter(cardViewPresidentAdapter);

    }

}

