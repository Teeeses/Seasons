package com.explead.twoseasons.ui.levels_ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.explead.twoseasons.R;
import com.explead.twoseasons.app.App;
import com.explead.twoseasons.beans.Level;
import com.explead.twoseasons.views.winter_views.SnowfallView;

/**
 * Created by Александр on 09.07.2017.
 */

public class WinterLevelsFragment extends LevelsFragment {

    private SnowfallView snowfall;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_levels_winter, container, false);

        snowfall = (SnowfallView) view.findViewById(R.id.snowfall);

        gvMain = (GridView) view.findViewById(R.id.gvMain);
        createButtons(App.getWinterLevels().size(), Level.WINTER);

        ImageView bottomImage = (ImageView) view.findViewById(R.id.bottomImage);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams((int) App.getWidthScreen(), (int)(App.getWidthScreen()*0.646f));
        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        bottomImage.setLayoutParams(params);

        return view;
    }

}
