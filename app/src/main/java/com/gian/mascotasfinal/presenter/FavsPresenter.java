package com.gian.mascotasfinal.presenter;

import android.content.Context;
import android.widget.Toast;

import com.gian.mascotasfinal.PetsConstructor;
import com.gian.mascotasfinal.R;
import com.gian.mascotasfinal.interfaces.IFavsPresenter;
import com.gian.mascotasfinal.interfaces.IRVFragmentPresenter;
import com.gian.mascotasfinal.pojo.Mascottas;

import java.util.ArrayList;

public class FavsPresenter implements IRVFragmentPresenter {

    private IFavsPresenter iFavsPresenter;
    private Context context;
    private PetsConstructor petsConstructor;
    private ArrayList<Mascottas> pets;


    public FavsPresenter(IFavsPresenter iFavsPresenter, Context context) {
        this.iFavsPresenter = iFavsPresenter;
        this.context = context;
        getPetsDB();

    }


    @Override
    public void getPetsDB() {
        petsConstructor = new PetsConstructor(context);
        pets = petsConstructor.get5Fav();
        showPetsRV();
    }


    @Override
    public void showPetsRV() {

        iFavsPresenter.iniAdapter(iFavsPresenter.createAdapter(pets));

        if (pets.size() == 0) {
            Toast.makeText(context, R.string.empty_favs_msg, Toast.LENGTH_LONG).show();
        }

        iFavsPresenter.mLinearLayoutVertical();

    }

}
