package com.example.fixed;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;



public class PagerAdapter extends FragmentPagerAdapter {
    private int tabmenu;

    public PagerAdapter(@NonNull  FragmentManager fm,int behaviour,int tabs) {
        super(fm,behaviour);
        this.tabmenu=tabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
             return  new Tentang();
            case 1:
                return new Kontak();
            default:
                return null;

        }


    }

    @Override
    public int getCount() {
        return tabmenu;
    }

}
