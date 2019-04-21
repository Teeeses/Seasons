package com.explead.seasons.common.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;

import com.explead.seasons.R;
import com.explead.seasons.common.adapters.MyPagerAdapter;
import com.explead.seasons.common.app.App;
import com.explead.seasons.common.beans.AllLevels;

import github.chenupt.springindicator.viewpager.ScrollerViewPager;

public class LevelsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
        App.setWidthScreen(displaymetrics.widthPixels);
        App.setHeightScreen(displaymetrics.heightPixels);

        ScrollerViewPager viewPager = findViewById(R.id.view_pager);

        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.fixScrollSpeed();

    }

    public void openGameActivity(int level, AllLevels.Month month) {
        Intent intent = new Intent(LevelsActivity.this, MainActivity.class);
        intent.putExtra("level", level);
        intent.putExtra("month", month);
        startActivity(intent);
    }
}
