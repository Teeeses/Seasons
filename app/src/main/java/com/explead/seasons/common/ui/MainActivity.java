package com.explead.seasons.common.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.explead.seasons.R;
import com.explead.seasons.common.beans.AllLevels;
import com.explead.seasons.winter.ui.fragments.WinterFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int level = getIntent().getExtras().getInt("level");
        AllLevels.Month month = (AllLevels.Month)getIntent().getExtras().get("month");

        openWinterFragment(level, month);
    }

    public void openWinterFragment(int level, AllLevels.Month month) {
        openFragment(new WinterFragment(), level, month);
    }

    public void openFragment(Fragment fragment, int level, AllLevels.Month month) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putInt("level", level);
        bundle.putSerializable("month", month);
        fragment.setArguments(bundle);
        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.commitAllowingStateLoss();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
