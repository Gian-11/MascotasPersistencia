package com.gian.mascotasfinal.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gian.mascotasfinal.pojo.MascotaenFragment;
import com.gian.mascotasfinal.R;

import java.util.ArrayList;

public class AdapterMascotas2 extends RecyclerView.Adapter<AdapterMascotas2.MascotasViewHolder> {

    ArrayList<MascotaenFragment> mascotas;


    public AdapterMascotas2(ArrayList<MascotaenFragment> mascotas) {
        this.mascotas = mascotas;
    }

    @NonNull
    @Override
    public MascotasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil, parent, false);
        return new MascotasViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotasViewHolder holder, int position) {
        MascotaenFragment mascota = mascotas.get(position);
        holder.ivFoto.setImageResource(mascota.getFoto());
        holder.tvRating.setText(Integer.toString(mascota.getRating()));
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotasViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvRating;
        private final ImageView ivFoto;


        public MascotasViewHolder(@NonNull View itemView) {
            super(itemView);
            tvRating = (TextView) itemView.findViewById(R.id.txtRatingPerfil);
            ivFoto = (ImageView) itemView.findViewById(R.id.imgFotoCardPefil);
        }
    }
}
