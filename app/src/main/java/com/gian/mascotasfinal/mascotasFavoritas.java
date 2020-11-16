package com.gian.mascotasfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.gian.mascotasfinal.adapters.AdapterFavPets;
import com.gian.mascotasfinal.pojo.Mascottas;
import com.gian.mascotasfinal.presenter.FavsPresenter;
import com.gian.mascotasfinal.interfaces.IFavsPresenter;
import com.gian.mascotasfinal.interfaces.IRVFragmentPresenter;

import java.util.ArrayList;

public class mascotasFavoritas extends AppCompatActivity implements IFavsPresenter {

    private RecyclerView rv;
    private ArrayList<Mascottas> mascotas;
    Menu menuEstrella;
    Activity activity;
    private IRVFragmentPresenter presenter;
    Context context;

    public mascotasFavoritas(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        rv = (RecyclerView) findViewById(R.id.rvRecyclerMascotasFav);

        presenter = new FavsPresenter(this, getApplicationContext());

        configToolbar();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        menu.setGroupVisible(R.id.groupStar, false);
        return true;
    }

    public void onRatingAction (MenuItem mi) {
    }

    public void onClickContact (MenuItem menuItem) {
        Intent intent1 = new Intent(mascotasFavoritas.this, Contact.class);
        startActivity(intent1);
    }

    public void onClickAbout (MenuItem menuItem) {
        Intent intent2 = new Intent(mascotasFavoritas.this, About.class);
        startActivity(intent2);
    }


    @Override
    public void mLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(llm);

    }

    @Override
    public AdapterFavPets createAdapter(ArrayList<Mascottas> mascotas) {
        AdapterFavPets adapter = new AdapterFavPets(mascotas, activity);
        return adapter;
    }

    @Override
    public void iniAdapter(AdapterFavPets adapter) {
        rv.setAdapter(adapter);
    }


    public void configToolbar () {

    Toolbar miActionbar = (Toolbar) findViewById(R.id.miActionBar2);
        TextView tituloActionbar = (TextView) findViewById(R.id.toolbar_title);
        setSupportActionBar(miActionbar);
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tituloActionbar.setText(R.string.activity2_title);
}


}



