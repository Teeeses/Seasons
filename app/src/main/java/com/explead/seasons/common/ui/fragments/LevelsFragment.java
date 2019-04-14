package com.explead.seasons.common.ui.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.GridView;
import android.widget.Toast;

import com.explead.seasons.R;
import com.explead.seasons.common.adapters.GridAdapter;
import com.explead.seasons.common.app.App;
import com.explead.seasons.common.beans.AllLevels;
import com.explead.seasons.common.beans.ButtonLevel;
import com.explead.seasons.common.ui.CustomGridView;
import com.explead.seasons.common.ui.LevelsActivity;

import java.util.ArrayList;

/**
 * Created by develop on 15.12.2016.
 */
public class LevelsFragment extends Fragment {

    protected LevelsActivity activity;
    protected CustomGridView gvDecember;
    protected CustomGridView gvJanuary;
    protected GridAdapter decemberAdapter;
    protected GridAdapter januaryAdapter;

    public void createButtons() {
        createDecemberGrid();
        createJanuaryGrid();
    }

    private void createDecemberGrid() {
        decemberAdapter = new GridAdapter(activity, App.getLevels().getDecemberEasyLevels().size(), new GridAdapter.OnLevelListener() {
            @Override
            public void onClickLevel(int level) {
                activity.openGameActivity(level, AllLevels.Month.DECEMBER);
            }

            @Override
            public void onLevelIsClose(int number) {
                Toast.makeText(activity, activity.getResources().getString(R.string.level_is_close), Toast.LENGTH_SHORT).show();
            }
        });
        gvDecember.setAdapter(decemberAdapter);
        gvDecember.setNumColumns(3);
    }

    private void createJanuaryGrid() {
        januaryAdapter = new GridAdapter(activity, App.getLevels().getJanuaryEasyLevels().size(), new GridAdapter.OnLevelListener() {
            @Override
            public void onClickLevel(int level) {
                activity.openGameActivity(level, AllLevels.Month.JANUARY);
            }

            @Override
            public void onLevelIsClose(int number) {
                Toast.makeText(activity, activity.getResources().getString(R.string.level_is_close), Toast.LENGTH_SHORT).show();
            }
        });
        gvJanuary.setAdapter(januaryAdapter);
        gvJanuary.setNumColumns(3);
    }

    @Override
    public void onResume() {
        if(decemberAdapter != null)
            decemberAdapter.refreshStatus();
        if(januaryAdapter != null)
            januaryAdapter.refreshStatus();
        super.onResume();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (LevelsActivity)context;
    }
}
