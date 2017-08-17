package com.explead.twoseasons.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.explead.twoseasons.ui.game_ui.fragments.SummerFragment;
import com.explead.twoseasons.ui.levels_ui.fragments.SummerLevelsFragment;
import com.explead.twoseasons.ui.levels_ui.fragments.WinterLevelsFragment;

/**
 * Created by develop on 13.12.2016.
 */
public class MyPagerAdapter extends FragmentPagerAdapter {

    private Fragment[] fragments = {
            new WinterLevelsFragment()
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