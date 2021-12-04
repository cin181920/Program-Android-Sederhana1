package com.example.fixed;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;


import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private RecyclerView rvKomik;
    private ArrayList<KomponenKomik> list = new ArrayList<>();

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;

    ViewFlipper v_flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//code reycleview
        rvKomik = findViewById(R.id.rv_komik2);
        rvKomik.setHasFixedSize(true);


//code view flipper
        int img[] ={R.drawable.boruto2,R.drawable.conan3,R.drawable.doraemon2};

        v_flipper= findViewById(R.id.v_flipper);

        for(int image:img){
            flipper_Images(image);
        }
//code reycle view
        list.addAll(DataKomik.getListData());
        showRecyclerCardView();
//code navigasi
        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer2);
        navigationView = findViewById(R.id.nav_view2);
        //navigationView.setNavigationItemSelectedListener(this);

        if(navigationView!=null){
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
    //code flipper
    public void flipper_Images(int images){
        ImageView imageView=new ImageView(this);
        imageView.setBackgroundResource(images);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(3000);
        v_flipper.setAutoStart(true);

        v_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }

    //code untuk pindah activity click listener
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.nav_lihat_semua_komik){
            Toast.makeText(this,"btn clicked",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Home.this,LihatKomik.class);
            Home.this.startActivity(intent);
            finish();
        }else if(id==R.id.nav_tentang){
            Toast.makeText(this,"btn clicked",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Home.this, Tentang3.class);
            Home.this.startActivity(intent);
            finish();
        }else if(id==R.id.nav_kembali){
            Toast.makeText(this,"btn clicked",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Home.this,MainActivity.class);
            Home.this.startActivity(intent);
            finish();
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }




}