package com.example.greficroot.chatapplication.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> fragmentArray = new ArrayList<>(2);
    private ArrayList<String> titleArray = new ArrayList<>(2);

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setFirstPage(Fragment fragment, String title){
        fragmentArray.add(0, fragment);
        titleArray.add(0, title);
    }
    public void setSecondPage(Fragment fragment, String title){
        fragmentArray.add(1, fragment);
        titleArray.add(1, title);
    }
    @Override
    public Fragment getItem(int i) {
        return fragmentArray.get(i);
    }

    @Override
    public int getCount() {
        return fragmentArray.size();
    }
}
