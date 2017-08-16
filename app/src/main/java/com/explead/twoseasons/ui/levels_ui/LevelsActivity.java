package com.explead.twoseasons.ui.levels_ui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;

import com.explead.twoseasons.R;
import com.explead.twoseasons.adapters.MyPagerAdapter;
import com.explead.twoseasons.app.App;
import com.explead.twoseasons.ui.game_ui.BaseActivity;
import com.explead.twoseasons.ui.game_ui.MainActivity;
import com.explead.twoseasons.utils.Utils;

import github.chenupt.springindicator.SpringIndicator;
import github.chenupt.springindicator.viewpager.ScrollerViewPager;

public class LevelsActivity extends BaseActivity {

    private ScrollerViewPager viewPager;
    private MyPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        sPref = getSharedPreferences(Utils.APP_PREFERENCES, MODE_PRIVATE);

        DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
        App.setWidthScreen(displaymetrics.widthPixels);
        App.setHeightScreen(displaymetrics.heightPixels);

        viewPager = (ScrollerViewPager) findViewById(R.id.view_pager);
        SpringIndicator springIndicator = (SpringIndicator) findViewById(R.id.indicator);

        adapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.fixScrollSpeed();

        springIndicator.setViewPager(viewPager);
    }

    public void openGameActivity(int mode, int level) {
        Intent intent = new Intent(LevelsActivity.this, MainActivity.class);
        intent.putExtra("mode", mode);
        intent.putExtra("level", level);
        startActivity(intent);
    }
}
