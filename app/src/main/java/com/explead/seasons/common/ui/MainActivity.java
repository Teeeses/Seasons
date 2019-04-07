package com.explead.seasons.common.ui;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;

import com.explead.seasons.R;
import com.explead.seasons.common.beans.Level;
import com.explead.seasons.summer.ui.fragments.SummerFragment;
import com.explead.seasons.winter.ui.fragments.WinterFragment;
import com.explead.seasons.common.utils.Utils;

public class MainActivity extends BaseActivity {

    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sPref = getSharedPreferences(Utils.APP_PREFERENCES, Context.MODE_PRIVATE);

        int mode = getIntent().getExtras().getInt("mode");
        int level = getIntent().getExtras().getInt("level");

        if(mode == Level.SUMMER) {
            openSummerFragment(level);
        } else if(mode == Level.WINTER) {
            openWinterFragment(level);
        }
    }

    public void openSummerFragment(int level) {
        openFragment(new SummerFragment(), level);
    }

    public void openWinterFragment(int level) {
        openFragment(new WinterFragment(), level);
    }

    public void openFragment(Fragment fragment, int level) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        this.fragment = fragment;
        Bundle bundle = new Bundle();
        bundle.putInt("level", level);
        fragment.setArguments(bundle);
        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.commitAllowingStateLoss();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public Fragment getFragment() {
        return fragment;
    }
}