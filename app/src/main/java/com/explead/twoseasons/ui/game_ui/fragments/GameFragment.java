package com.explead.twoseasons.ui.game_ui.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.ImageView;
import android.widget.TextView;

import com.explead.twoseasons.ui.game_ui.MainActivity;
import com.explead.twoseasons.views.SummerFieldView;

/**
 * Created by Александр on 09.07.2017.
 */

public class GameFragment extends Fragment {

    protected MainActivity activity;

    protected ImageView btnRestart;
    protected ImageView btnMenu;
    protected TextView tvNumberLevel;
    protected TextView tvLevel;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (MainActivity) context;
    }
}