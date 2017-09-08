package com.explead.twoseasons.ui.game_ui.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.explead.twoseasons.R;
import com.explead.twoseasons.app.App;
import com.explead.twoseasons.logic.controllers.BaseController;
import com.explead.twoseasons.logic.controllers.SummerController;
import com.explead.twoseasons.logic.elements.Cell;
import com.explead.twoseasons.utils.Utils;
import com.explead.twoseasons.views.summer_views.FieldSummerView;

/**
 * Created by Александр on 09.07.2017.
 */

public class SummerFragment extends GameFragment implements BaseController.OnGameListener, FieldSummerView.OnActionField, SummerController.OnControllerListener {

    private SummerController controller;
    private FieldSummerView mFieldSummerView;

    int level;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_summer, container, false);

        level = getArguments().getInt("level");

        tvNumberLevel = (TextView) view.findViewById(R.id.tvNumberLevel);
        tvLevel = (TextView) view.findViewById(R.id.tvLevel);
        tvNumberLevel.setTypeface(Utils.getTypeFaceLevel(getContext().getAssets()));
        tvLevel.setTypeface(Utils.getTypeFaceLevel(getContext().getAssets()));

        mFieldSummerView = (FieldSummerView) view.findViewById(R.id.fieldView);

        tvNumberLevel.setText(String.format("%s", level));

        btnRestart = (ImageView) view.findViewById(R.id.btnRestart);
        btnRestart.setOnClickListener(btnRestartClick);

        btnMenu = (ImageView) view.findViewById(R.id.btnMenu);
        btnMenu.setOnClickListener(btnMenuClick);

        startGame();

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
            startGame();
        }
    };

    private void startGame() {
        controller = new SummerController(level);
        controller.setOnControllerListener(SummerFragment.this);
        controller.setOnGameListener(SummerFragment.this);

        mFieldSummerView.createField(App.getWidthScreen()*0.96f, controller.getField());
        mFieldSummerView.setOnActionField(this);
    }

    @Override
    public void onWin() {
        Toast.makeText(getContext(), "WIN", Toast.LENGTH_SHORT).show();
        activity.setCurrentSummerLevel(controller.getLevel());
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                activity.onBackPressed();
            }
        }, 1000);
    }

    @Override
    public void onAddCellOnPath(Cell cell) {
        mFieldSummerView.addCellOnPath(cell);
    }

    @Override
    public void onDeleteLastFromPath() {
        mFieldSummerView.deleteLastFromPath();
    }

    @Override
    public void onAddingPathOnField() {
        mFieldSummerView.addingPathOnField();
    }

    @Override
    public void onDeleteAllPath() {
        mFieldSummerView.deleteAllPath();
    }

    @Override
    public void onFingerUp(int x, int y) {
        controller.endPath();
    }

    @Override
    public void onFingerMove(int x, int y) {
        controller.addingCell(x, y);
    }

    @Override
    public void onFingerDown(int x, int y) {
        controller.startPath(x, y);
    }

}
