package com.gian.mascotasfinal.interfaces;

import android.widget.Adapter;

import com.gian.mascotasfinal.adapters.AdapterFavPets;
import com.gian.mascotasfinal.adapters.AdapterMascotas;
import com.gian.mascotasfinal.pojo.Mascottas;

import java.util.ArrayList;

public interface IFavsPresenter {
    public void mLinearLayoutVertical ();
    public AdapterFavPets createAdapter (ArrayList<Mascottas> mascotas);
    public void iniAdapter (AdapterFavPets adapter);
}
