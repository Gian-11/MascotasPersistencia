package com.gian.mascotasfinal.presenter;

import android.content.Context;

import com.gian.mascotasfinal.PetsConstructor;
import com.gian.mascotasfinal.interfaces.IrvFragmentsView;
import com.gian.mascotasfinal.interfaces.IRVFragmentPresenter;
import com.gian.mascotasfinal.pojo.Mascottas;

import java.util.ArrayList;

public class RVFragmentPresenter implements IRVFragmentPresenter {

    private PetsConstructor petsConstructor;
    private Context context;
    private ArrayList<Mascottas> pets;
    private IrvFragmentsView irvFragmentsView;


    public RVFragmentPresenter(IrvFragmentsView irvFragmentsView, Context context) {
        this.irvFragmentsView = irvFragmentsView;
        this.context = context;
        getPetsDB();
    }


    @Override
    public void getPetsDB() {
        petsConstructor = new PetsConstructor(context);
        pets = petsConstructor.getPetsData();
        showPetsRV();

    }

    @Override
    public void showPetsRV() {
        irvFragmentsView.iniAdapter(irvFragmentsView.createAdapter(pets));
        irvFragmentsView.mLinearLayoutVertical();
    }



}
