package com.explead.seasons.common.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.explead.seasons.summer.ui.fragments.SummerLevelsFragment;
import com.explead.seasons.winter.ui.fragments.WinterLevelsFragment;

/**
 * Created by develop on 13.12.2016.
 */
public class MyPagerAdapter extends FragmentPagerAdapter {

    private Fragment[] fragments = {
            new WinterLevelsFragment(), new SummerLevelsFragment()
    };

    public MyPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    public String getPageTitle(int position) {
        return Integer.toString(position + 1);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }
}