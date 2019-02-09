package com.explead.seasons.common.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;

import com.explead.seasons.R;
import com.explead.seasons.common.adapters.MyPagerAdapter;
import com.explead.seasons.common.app.App;
import com.explead.seasons.common.utils.Utils;

import github.chenupt.springindicator.viewpager.ScrollerViewPager;

public class LevelsActivity extends BaseActivity {

    private ScrollerViewPager viewPager;
    private MyPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        sPref = getSharedPreferences(Utils.APP_PREFERENCES, Context.MODE_PRIVATE);

        DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
        App.setWidthScreen(displaymetrics.widthPixels);
        App.setHeightScreen(displaymetrics.heightPixels);

        viewPager = (ScrollerViewPager) findViewById(R.id.view_pager);

        adapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.fixScrollSpeed();

    }

    public void openGameActivity(int mode, int level) {
        Intent intent = new Intent(LevelsActivity.this, MainActivity.class);
        intent.putExtra("mode", mode);
        intent.putExtra("level", level);
        startActivity(intent);
    }
}
