package com.example.android.toy;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.android.toy.Fragments.BodyFragment;
import com.example.android.toy.Fragments.HeadFragment;
import com.example.android.toy.Fragments.LegFragment;

public class SimplePageAdapter extends FragmentPagerAdapter {

    String[]tabTitles ={"Head", "Body", "Leg"};
    Context context;

    public SimplePageAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0){
            return new HeadFragment();
        }else if (position == 1){
            return new BodyFragment();
        }else{
            return new LegFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        return tabTitles[position];
    }
}
