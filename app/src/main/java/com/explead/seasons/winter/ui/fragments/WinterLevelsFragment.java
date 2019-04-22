package com.explead.seasons.winter.ui.fragments;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.explead.seasons.R;
import com.explead.seasons.common.app.App;
import com.explead.seasons.common.ui.fragments.LevelsFragment;
import com.explead.seasons.common.utils.Utils;
import com.explead.seasons.winter.ui.winter_views.SnowfallView;

/**
 * Created by Александр on 09.07.2017.
 */

public class WinterLevelsFragment extends LevelsFragment {

    private SnowfallView snowfall;
    //private SoundPool soundPool;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_levels_winter, container, false);

        snowfall = view.findViewById(R.id.snowfall);
        snowfall.startAnimation();

        /*soundPool = new SoundPool(4, AudioManager.STREAM_MUSIC, 100);
        soundPool.load(getActivity(), R.raw.sound_winter_jingle, 1);
        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                soundPool.play(sampleId, 0.5f, 0.5f, 1, 0, 1f);
            }
        });*/

        TextView tvDecember = view.findViewById(R.id.tvDecember);
        tvDecember.setTypeface(Utils.getTypeFaceLevel(getContext().getAssets()));
        TextView tvJanuary = view.findViewById(R.id.tvJanuary);
        tvJanuary.setTypeface(Utils.getTypeFaceLevel(getContext().getAssets()));

        ScrollView scroll = view.findViewById(R.id.scroll);
        scroll.smoothScrollTo(0, 0);

        gvDecember = view.findViewById(R.id.gvDecember);
        gvJanuary = view.findViewById(R.id.gvJanuary);
        createButtons();

        ImageView bottomImage = view.findViewById(R.id.bottomImage);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams((int) App.getWidthScreen(), (int)(App.getWidthScreen()*0.646f));
        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        bottomImage.setLayoutParams(params);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if(snowfall != null)
            snowfall.startAnimation();
    }

    @Override
    public void onStop() {
        super.onStop();
        if(snowfall != null)
            snowfall.stopAnimation();
    }

    @Override
    public void onDestroy() {
        if(snowfall != null)
            snowfall.stopAnimation();
        super.onDestroy();
    }
}
