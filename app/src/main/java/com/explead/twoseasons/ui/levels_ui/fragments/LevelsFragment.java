package com.explead.twoseasons.ui.levels_ui.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.GridView;
import android.widget.Toast;

import com.explead.twoseasons.R;
import com.explead.twoseasons.adapters.GridAdapter;
import com.explead.twoseasons.beans.ButtonLevel;
import com.explead.twoseasons.ui.levels_ui.LevelsActivity;

import java.util.ArrayList;

/**
 * Created by develop on 15.12.2016.
 */
public class LevelsFragment extends Fragment {

    protected LevelsActivity activity;
    protected ArrayList<ButtonLevel> array = new ArrayList<>();
    protected GridView gvMain;
    protected GridAdapter adapter;

    public void createButtons(int size, int mode) {
        this.array.clear();
        for(int i = 0; i < size; i++) {
            array.add(new ButtonLevel(activity, mode, i + 1));
        }
        adapter = new GridAdapter(getContext(), array, new GridAdapter.OnLevelListener() {
            @Override
            public void onClickLevel(int mode, int level) {
                activity.openGameActivity(mode, level);
            }

            @Override
            public void onLevelIsClose(int number) {
                Toast.makeText(activity, activity.getResources().getString(R.string.level_is_close), Toast.LENGTH_SHORT).show();
            }
        });
        gvMain.setAdapter(adapter);
        gvMain.setNumColumns(3);
    }

    public void refreshStatus() {
        for(int i = 0; i < array.size(); i++) {
            array.get(i).findStatus();
        }
    }

    @Override
    public void onResume() {
        refreshStatus();
        if(adapter != null) {
            adapter.notifyDataSetChanged();
        }
        super.onResume();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (LevelsActivity)context;
    }
}
