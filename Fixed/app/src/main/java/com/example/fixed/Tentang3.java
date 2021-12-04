package com.example.fixed;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class Tentang3 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    ViewPager pager;
    TabLayout mTablayout;
    TabItem itemTentang,itemKontak;
    PagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang3);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        pager=findViewById(R.id.viewpager);
        mTablayout=findViewById(R.id.tabLayout);
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        itemTentang=findViewById(R.id.item_tentang);
        itemKontak=findViewById(R.id.item_kontak);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();

        adapter=new PagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,mTablayout.getTabCount());
        pager.setAdapter(adapter);

        mTablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTablayout));
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.nav_lihat_semua_komik){
            Toast.makeText(this,"btn clicked",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Tentang3.this, LihatKomik.class);
            Tentang3.this.startActivity(intent);
            finish();
        }else if(item.getItemId()==R.id.nav_home){
            Toast.makeText(this,"btn clicked",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Tentang3.this, Home.class);
            Tentang3.this.startActivity(intent);
            finish();
        }else if(item.getItemId()==R.id.nav_kembali){
            Intent intent = new Intent(Tentang3.this, MainActivity.class);
            Tentang3.this.startActivity(intent);
            finish();
            Toast.makeText(this,"btn clicked",Toast.LENGTH_SHORT).show();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}