package com.gian.mascotasfinal.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gian.mascotasfinal.MainActivity;
import com.gian.mascotasfinal.PetsConstructor;
import com.gian.mascotasfinal.R;
import com.gian.mascotasfinal.pojo.Mascottas;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class AdapterFavPets extends RecyclerView.Adapter<AdapterFavPets.MascotasViewHolder> {

    ArrayList<Mascottas> mascotas;
    Activity activity;
    View view;
    Context context;

    public AdapterFavPets(ArrayList<Mascottas> mascotas, Activity activity) {
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



    }

    public static class MascotasViewHolder extends RecyclerView.ViewHolder {
      private final TextView tvNombre;
      private final TextView tvRating;
      private final ImageView ivFoto;



        public MascotasViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = (TextView) itemView.findViewById(R.id.txtNombre);
            tvRating = (TextView) itemView.findViewById(R.id.txtRating);
            ivFoto = (ImageView) itemView.findViewById(R.id.imgFoto);








        }

    }








    @Override
    public int getItemCount() {
        return mascotas.size();
    }





    }



