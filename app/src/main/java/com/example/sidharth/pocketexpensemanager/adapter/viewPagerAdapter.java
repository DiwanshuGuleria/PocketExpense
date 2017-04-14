package com.example.sidharth.pocketexpensemanager.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Sidharth on 3/5/2017.
 */

public class viewPagerAdapter extends FragmentPagerAdapter{
    ArrayList<Fragment> fragments=new ArrayList<>();
    ArrayList<String> tabtitles=new ArrayList<>();

    public void addFragments(Fragment fragment,String titles)
    {
        this.fragments.add(fragment);
        this.tabtitles.add(titles);
    }

    public viewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabtitles.get(position);
    }
}
