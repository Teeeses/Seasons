package com.explead.seasons.common.ui.fragments;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.explead.seasons.R;
import com.explead.seasons.common.adapters.GridAdapter;
import com.explead.seasons.common.beans.AllLevels;
import com.explead.seasons.common.beans.ButtonLevel;
import com.explead.seasons.common.ui.LevelsActivity;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;


/**
 * Created by develop on 15.12.2016.
 */
public class LevelsFragment extends Fragment implements GridAdapter.OnLevelListener {

    protected View view;

    protected LevelsActivity activity;

    private Snackbar sbLevelClosed;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createSB(view);
    }

    private void createSB(@NonNull View view) {
        sbLevelClosed = Snackbar.make(view, activity.getResources().getString(R.string.level_is_close), Snackbar.LENGTH_SHORT);
        View sbView = sbLevelClosed.getView();
        TextView tv = sbView.findViewById(R.id.snackbar_text);
        tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tv.setGravity(Gravity.CENTER_HORIZONTAL);
        tv.setTypeface(Typeface.createFromAsset(requireContext().getAssets(), "font/level_personal.ttf"));
    }

    protected GridAdapter createGrid(final AllLevels.Month month) {
        return new GridAdapter(activity, create(month), month, this);
    }

    @Override
    public void onClickLevel(int level, AllLevels.Month month) {
        activity.openGameActivity(level, month);
    }

    @Override
    public void onLevelIsClose(int number) {
        if(!sbLevelClosed.isShown()) {
            sbLevelClosed.show();
        }
    }

    private ArrayList<ButtonLevel> create(AllLevels.Month month) {
        ArrayList<ButtonLevel> array = new ArrayList<>();
        for(int i = 0; i < month.getDeis(); i++) {
            array.add(new ButtonLevel(i + 1));
        }
        return array;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (LevelsActivity)context;
    }
}
