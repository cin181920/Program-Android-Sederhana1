package com.example.fixed;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;


import java.util.ArrayList;

public class ListKomikAdapter extends RecyclerView.Adapter<ListKomikAdapter.CardViewViewHolder> {
    private ArrayList<KomponenKomik> listkomik;


    public ListKomikAdapter(ArrayList<KomponenKomik> list) {

        this.listkomik = list;


    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_cardview, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewViewHolder holder, int position) {

        KomponenKomik komik = listkomik.get(position);
        Glide.with(holder.itemView.getContext())
                .load(komik.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);
        holder.tvName.setText(komik.getName());
        holder.tvDetail.setText(komik.getDetail());

        //click event



    }



    @Override
    public int getItemCount() {
        return listkomik.size();
    }

    class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDetail;

        CardViewViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);
        }
    }


}