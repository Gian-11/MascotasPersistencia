package com.gian.mascotasfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.gian.mascotasfinal.adapters.AdapterMascotas;
import com.gian.mascotasfinal.adapters.PagerAdapter;
import com.gian.mascotasfinal.fragments.PerfilFragment;
import com.gian.mascotasfinal.fragments.RecyclerViewFragment;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    Menu menuEstrella;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Toolbar toolBar;
    Context context;
    private ImageView likeBone;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        toolBar = (Toolbar) findViewById(R.id.toolBar);

        configToolbar();
        setViewPager();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    public void onRatingAction (MenuItem mi) {
        Intent intent = new Intent (MainActivity.this, mascotasFavoritas.class);
        startActivity(intent);
    }

    private ArrayList<Fragment> agregarFragments () {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }

    public void setViewPager () {
        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_baseline_home_24);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_dogface);
    }

    public void onClickContact (MenuItem menuItem) {
        Intent intent1 = new Intent(MainActivity.this, Contact.class);
        startActivity(intent1);
    }

    public void onClickAbout (MenuItem menuItem) {
        Intent intent2 = new Intent(MainActivity.this, About.class);
        startActivity(intent2);
    }

    public void configToolbar() {
        TextView tituloActionbar = (TextView) findViewById(R.id.toolbar_title);
        setSupportActionBar(toolBar);
        getSupportActionBar().setIcon(R.drawable.ic_huella);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        tituloActionbar.setText(R.string.app_name_actionbar);

    }

}







