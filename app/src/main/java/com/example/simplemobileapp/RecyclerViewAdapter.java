package com.example.simplemobileapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context context;
    String[] itemNameData, itemPriceData;
    int[] imageResources;

    public RecyclerViewAdapter(Context ct, String[] itemsAll, String[] priceAll, int[] imagesAll) {
        context = ct;
        itemNameData = itemsAll;
        itemPriceData = priceAll;
        imageResources = imagesAll;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView itemText, priceText;
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemText = itemView.findViewById(R.id.item_text);
            priceText = itemView.findViewById(R.id.price_text);
            imageView = itemView.findViewById(R.id.image_view);
        }

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.itemText.setText(itemNameData[position]);
        holder.priceText.setText(itemPriceData[position]);
        holder.imageView.setImageResource(imageResources[position]);
    }

    @Override
    public int getItemCount() {
        return imageResources.length;
    }

}
