package com.explead.twoseasons.ui.game_ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.explead.twoseasons.R;
import com.explead.twoseasons.app.App;
import com.explead.twoseasons.logic.controllers.Modes;
import com.explead.twoseasons.logic.controllers.SummerController;
import com.explead.twoseasons.logic.elements.Cell;
import com.explead.twoseasons.utils.Utils;
import com.explead.twoseasons.views.summer_views.FieldSummerView;

import java.util.ArrayList;

/**
 * Created by Александр on 09.07.2017.
 */

public class SummerFragment extends GameFragment implements Modes.OnGameListener, FieldSummerView.OnActionField, SummerController.OnControllerListener {

    private SummerController controller;
    private FieldSummerView mFieldSummerView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_summer, container, false);

        int level = getArguments().getInt("level");
        controller = new SummerController(level);

        tvNumberLevel = (TextView) view.findViewById(R.id.tvNumberLevel);
        tvLevel = (TextView) view.findViewById(R.id.tvLevel);
        tvNumberLevel.setTypeface(Utils.getTypeFaceLevel(getContext().getAssets()));
        tvLevel.setTypeface(Utils.getTypeFaceLevel(getContext().getAssets()));

        mFieldSummerView = (FieldSummerView) view.findViewById(R.id.fieldView);
        mFieldSummerView.createField(App.getWidthScreen()*0.96f, controller.getField());
        mFieldSummerView.setOnTouch();
        mFieldSummerView.setOnActionField(this);

        tvNumberLevel.setText(String.format("%s", level));

        btnRestart = (ImageView) view.findViewById(R.id.btnRestart);
        btnRestart.setOnClickListener(btnRestartClick);


        btnMenu = (ImageView) view.findViewById(R.id.btnMenu);
        btnMenu.setOnClickListener(btnMenuClick);

        return view;
    }

    View.OnClickListener btnMenuClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            getActivity().onBackPressed();
        }
    };

    View.OnClickListener btnRestartClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };


    @Override
    public void onWin() {

    }

    @Override
    public void onUp(int x, int y) {

    }

    @Override
    public void onMove(int x, int y) {

    }

    @Override
    public void onDown(int x, int y) {
        controller.down(x, y);
    }

    @Override
    public void onChangePath(ArrayList<ArrayList<Cell>> result) {
        mFieldSummerView.changePath(result);
    }
}
