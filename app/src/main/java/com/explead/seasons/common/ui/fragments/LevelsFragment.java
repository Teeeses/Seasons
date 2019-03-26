package com.explead.seasons.common.ui.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.GridView;
import android.widget.Toast;

import com.explead.seasons.R;
import com.explead.seasons.common.adapters.GridAdapter;
import com.explead.seasons.common.beans.ButtonLevel;
import com.explead.seasons.common.ui.LevelsActivity;

import java.util.ArrayList;

/**
 * Created by develop on 15.12.2016.
 */
public class LevelsFragment extends Fragment {

    protected LevelsActivity activity;
    protected ArrayList<ButtonLevel> array = new ArrayList<>();
    protected GridView gvDecember;
    protected GridView gvJanuary;
    protected GridView gvFebruary;
    protected GridAdapter decemberAdapter;
    protected GridAdapter januaryAdapter;
    protected GridAdapter februaryAdapter;

    public void createButtons(int size, int mode) {
        for(int i = 0; i < size; i++) {
            array.add(new ButtonLevel(activity, mode, i + 1));
        }

        createDecemberGrid();
        createJanuaryGrid();
        createFebruaryGrid();

    }

    private void createDecemberGrid(ArrayList<ButtonLevel> array, int mode) {
        decemberAdapter = new GridAdapter(activity, array, mode, new GridAdapter.OnLevelListener() {
            @Override
            public void onClickLevel(int mode, int level) {
                activity.openGameActivity(mode, level);
            }

            @Override
            public void onLevelIsClose(int number) {
                Toast.makeText(activity, activity.getResources().getString(R.string.level_is_close), Toast.LENGTH_SHORT).show();
            }
        });
        gvDecember.setAdapter(decemberAdapter);
        gvDecember.setNumColumns(3);
    }

    private void createJanuaryGrid(ArrayList<ButtonLevel> array, int mode) {
        januaryAdapter = new GridAdapter(activity, array, mode, new GridAdapter.OnLevelListener() {
            @Override
            public void onClickLevel(int mode, int level) {
                activity.openGameActivity(mode, level);
            }

            @Override
            public void onLevelIsClose(int number) {
                Toast.makeText(activity, activity.getResources().getString(R.string.level_is_close), Toast.LENGTH_SHORT).show();
            }
        });
        gvJanuary.setAdapter(januaryAdapter);
        gvJanuary.setNumColumns(3);
    }

    private void createFebruaryGrid(ArrayList<ButtonLevel> array, int mode) {
        februaryAdapter = new GridAdapter(activity, array, mode, new GridAdapter.OnLevelListener() {
            @Override
            public void onClickLevel(int mode, int level) {
                activity.openGameActivity(mode, level);
            }

            @Override
            public void onLevelIsClose(int number) {
                Toast.makeText(activity, activity.getResources().getString(R.string.level_is_close), Toast.LENGTH_SHORT).show();
            }
        });
        gvFebruary.setAdapter(februaryAdapter);
        gvFebruary.setNumColumns(3);
    }

    public void refreshStatus() {
        for(int i = 0; i < array.size(); i++) {
            array.get(i).findStatus();
        }
    }

    @Override
    public void onResume() {
        refreshStatus();
        if(decemberAdapter != null)
            decemberAdapter.notifyDataSetChanged();
        if(januaryAdapter != null)
            januaryAdapter.notifyDataSetChanged();
        if(februaryAdapter != null)
            februaryAdapter.notifyDataSetChanged();
        super.onResume();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (LevelsActivity)context;
    }
}
