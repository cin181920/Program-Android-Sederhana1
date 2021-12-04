package com.example.fixed;

import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class LihatKomik extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private RecyclerView rvKomik;
    private ArrayList<KomponenKomik> list = new ArrayList<>();

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;

    ViewFlipper v_flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_komik);
//code reycleview
        rvKomik = findViewById(R.id.rv_komik);
        rvKomik.setHasFixedSize(true);
        //code reycle view
        list.addAll(DataKomik.getListData());
        showRecyclerCardView();
//code navigasi
        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer3);
        navigationView = findViewById(R.id.nav_view3);
        //navigationView.setNavigationItemSelectedListener(this);

        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(this);
        }


        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();
    }
    //code reycle view
    private void showRecyclerCardView(){
        rvKomik.setLayoutManager(new LinearLayoutManager(this));
        ListKomikAdapter cardViewKomikAdapter = new ListKomikAdapter(list);
        rvKomik.setAdapter(cardViewKomikAdapter);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.nav_tentang){
            Toast.makeText(this,"btn clicked",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LihatKomik.this, Tentang3.class);
            LihatKomik.this.startActivity(intent);
            finish();
        }else if(item.getItemId()==R.id.nav_home){
            Toast.makeText(this,"btn clicked",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LihatKomik.this,Home.class);
            LihatKomik.this.startActivity(intent);
            finish();
        }else if(item.getItemId()==R.id.nav_kembali){
            Intent intent = new Intent(LihatKomik.this, MainActivity.class);
            LihatKomik.this.startActivity(intent);
            finish();
            Toast.makeText(this,"btn clicked",Toast.LENGTH_SHORT).show();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    }