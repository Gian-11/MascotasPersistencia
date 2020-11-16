package com.gian.mascotasfinal.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gian.mascotasfinal.PetsConstructor;
import com.gian.mascotasfinal.pojo.Mascottas;
import com.gian.mascotasfinal.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class AdapterMascotas extends RecyclerView.Adapter<AdapterMascotas.MascotasViewHolder> {

    ArrayList<Mascottas> mascotas;
    Activity activity;
    View view;
    Context context;

    public AdapterMascotas(ArrayList<Mascottas> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }


    @NonNull
    @Override
    public MascotasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);

        return new MascotasViewHolder(v);
    }


    @Override
    public void onBindViewHolder(final MascotasViewHolder holder, int position) {
    final Mascottas mascota = mascotas.get(position);
    holder.ivFoto.setImageResource(mascota.getFoto());
    holder.tvNombre.setText(mascota.getNombre());
    holder.tvRating.setText(String.valueOf(mascota.getLikes()));



    holder.imgBoneLike.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {

                Snackbar.make(view, R.string.mensaje_snackbar, Snackbar.LENGTH_SHORT).show();

                PetsConstructor petsConstructor = new PetsConstructor(activity);
                petsConstructor.giveLike(mascota);
                holder.tvRating.setText(petsConstructor.obLikesPet(mascota) + " " + activity.getString(R.string.likes));

            }


        });

    }

    public static class MascotasViewHolder extends RecyclerView.ViewHolder {
      private final TextView tvNombre;
      private final TextView tvRating;
      private final ImageView ivFoto;
      private final ImageView imgBoneLike;


        public MascotasViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = (TextView) itemView.findViewById(R.id.txtNombre);
            tvRating = (TextView) itemView.findViewById(R.id.txtRating);
            ivFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            imgBoneLike = (ImageView) itemView.findViewById(R.id.imgHueso);







        }

    }








    @Override
    public int getItemCount() {
        return mascotas.size();
    }





    }



