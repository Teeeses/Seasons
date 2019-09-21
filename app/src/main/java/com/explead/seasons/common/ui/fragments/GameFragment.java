package com.explead.seasons.common.ui.fragments;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.explead.seasons.common.ui.MainActivity;

/**
 * Created by Александр on 09.07.2017.
 */

public class GameFragment extends Fragment {

    protected MainActivity activity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (MainActivity) context;
    }
}
