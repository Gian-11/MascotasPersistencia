package com.gian.mascotasfinal.interfaces;

import com.gian.mascotasfinal.adapters.AdapterMascotas;
import com.gian.mascotasfinal.pojo.Mascottas;

import java.util.ArrayList;

public interface IrvFragmentsView {

    public void mLinearLayoutVertical ();
    public AdapterMascotas createAdapter (ArrayList<Mascottas> mascotas);
    public void iniAdapter (AdapterMascotas adapter);
}
