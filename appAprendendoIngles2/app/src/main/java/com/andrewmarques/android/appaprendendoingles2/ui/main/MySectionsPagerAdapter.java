package com.andrewmarques.android.appaprendendoingles2.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.andrewmarques.android.appaprendendoingles2.Fragments.NumerosFragment;
import com.andrewmarques.android.appaprendendoingles2.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class MySectionsPagerAdapter extends FragmentPagerAdapter {

    private static List<String> TAB_TITLES;
    private static List<Fragment> TAB_FRAGMENTS;
    private final Context mContext;

    public MySectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;

        TAB_FRAGMENTS = new ArrayList<>();
        TAB_TITLES = new ArrayList<>();
    }

    public void addPage (String title, Fragment fragment){
        TAB_TITLES.add(title);
        TAB_FRAGMENTS.add(fragment);
    }

    @Override
    public Fragment getItem(int position) {
        if(TAB_FRAGMENTS.size() > 0){
            return TAB_FRAGMENTS.get(position);
        }else {
            return new Fragment();
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(TAB_TITLES.size() > 0){
            return TAB_TITLES.get(position);
        }else {
            return new String("");
        }

    }

    @Override
    public int getCount() {
        return TAB_TITLES.size();
    }
}