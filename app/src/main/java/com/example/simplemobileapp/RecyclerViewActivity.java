package com.example.simplemobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView listItemsView;

    String[] itemsAll, priceAll;

    int images[] = {
            R.drawable.cola,
            R.drawable.maggi,
            R.drawable.milo,
            R.drawable.nescafe,
            R.drawable.shampoo,
            R.drawable.walls,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        itemsAll = getResources().getStringArray(R.array.items);
        priceAll = getResources().getStringArray(R.array.price);

        listItemsView = findViewById(R.id.listItems);
        RecyclerViewAdapter viewAdapter = new RecyclerViewAdapter(this, itemsAll, priceAll, images);

        listItemsView.setAdapter(viewAdapter);
        listItemsView.setLayoutManager(new LinearLayoutManager(this));

    }

}