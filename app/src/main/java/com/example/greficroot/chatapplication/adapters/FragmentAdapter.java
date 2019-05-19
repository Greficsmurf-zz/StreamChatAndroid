package com.example.greficroot.chatapplication.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> fragmentArray = new ArrayList<>();
    private List<String> titleArray = new ArrayList<>();

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    public void add(Fragment fragment, String title){
        fragmentArray.add(fragment);
        titleArray.add(title);
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
