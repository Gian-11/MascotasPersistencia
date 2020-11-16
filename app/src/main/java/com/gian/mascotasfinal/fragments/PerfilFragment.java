package com.gian.mascotasfinal.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gian.mascotasfinal.adapters.AdapterMascotas2;
import com.gian.mascotasfinal.pojo.MascotaenFragment;
import com.gian.mascotasfinal.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PerfilFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PerfilFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<MascotaenFragment> mascota;
    DividerItemDecoration decor;
    DividerItemDecoration decor2;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    public PerfilFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PerfilFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PerfilFragment newInstance(String param1, String param2) {
        PerfilFragment fragment = new PerfilFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.rvRecyclerMascotasFragment);

        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);
        recyclerView.setLayoutManager(glm);

        decor = new DividerItemDecoration(getActivity(), DividerItemDecoration.HORIZONTAL);
        decor2 = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.dividers, getContext().getTheme());
        decor.setDrawable(drawable);
        decor2.setDrawable(drawable);

        recyclerView.addItemDecoration(decor);
        recyclerView.addItemDecoration(decor2);

        crear();
        iniAdaptador();

        return v;

    }

    public void crear() {
        mascota = new ArrayList<MascotaenFragment>();
        mascota.add(new MascotaenFragment(R.drawable.mascota2, 10));
        mascota.add(new MascotaenFragment(R.drawable.mascota2, 33));
        mascota.add(new MascotaenFragment(R.drawable.mascota2, 3));
        mascota.add(new MascotaenFragment(R.drawable.mascota2, 4));
        mascota.add(new MascotaenFragment(R.drawable.mascota2, 5));
        mascota.add(new MascotaenFragment(R.drawable.mascota2, 9));
        mascota.add(new MascotaenFragment(R.drawable.mascota2, 23));
        mascota.add(new MascotaenFragment(R.drawable.mascota2, 4));
        mascota.add(new MascotaenFragment(R.drawable.mascota2, 3));
        mascota.add(new MascotaenFragment(R.drawable.mascota2, 100));
        mascota.add(new MascotaenFragment(R.drawable.mascota2, 50));
        mascota.add(new MascotaenFragment(R.drawable.mascota2, 7));
    }

    public void iniAdaptador () {
        AdapterMascotas2 adaptador = new AdapterMascotas2(mascota);
        recyclerView.setAdapter(adaptador);


    }


}