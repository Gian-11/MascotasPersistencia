package com.gian.mascotasfinal.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gian.mascotasfinal.PetsConstructor;
import com.gian.mascotasfinal.adapters.AdapterMascotas;
import com.gian.mascotasfinal.interfaces.IrvFragmentsView;
import com.gian.mascotasfinal.pojo.Mascottas;
import com.gian.mascotasfinal.R;
import com.gian.mascotasfinal.interfaces.IRVFragmentPresenter;
import com.gian.mascotasfinal.presenter.RVFragmentPresenter;

import java.util.ArrayList;


public class RecyclerViewFragment extends Fragment implements IrvFragmentsView {


    private RecyclerView listadeM;
    private ArrayList<Mascottas> mascotas;
    private PetsConstructor petsConstructor;
    private Context context;
    private IRVFragmentPresenter presenter;

    public RecyclerViewFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        listadeM = (RecyclerView) v.findViewById(R.id.rvRecyclerMascotas);
        presenter = new RVFragmentPresenter(this, getContext());
        return v;

    }


    @Override
    public void mLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listadeM.setLayoutManager(llm);
    }

    @Override
    public AdapterMascotas createAdapter(ArrayList<Mascottas> mascotas) {
        AdapterMascotas adapter = new AdapterMascotas(mascotas, getActivity());
        return adapter;
    }

    @Override
    public void iniAdapter(AdapterMascotas adapter) {
        listadeM.setAdapter(adapter);
    }

}