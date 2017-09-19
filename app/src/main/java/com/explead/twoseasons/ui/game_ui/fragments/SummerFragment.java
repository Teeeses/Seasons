package com.explead.twoseasons.ui.game_ui.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.explead.twoseasons.R;
import com.explead.twoseasons.app.App;
import com.explead.twoseasons.dialogs.DialogLevelCompletion;
import com.explead.twoseasons.dialogs.DialogSummerHelp;
import com.explead.twoseasons.dialogs.DialogWinterHelp;
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

    private int level;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_summer, container, false);

        level = getArguments().getInt("level");

        tvNumberLevel = (TextView) view.findViewById(R.id.tvNumberLevel);
        tvLevel = (TextView) view.findViewById(R.id.tvLevel);
        tvNumberLevel.setTypeface(Utils.getTypeFaceLevel(getContext().getAssets()));
        tvLevel.setTypeface(Utils.getTypeFaceLevel(getContext().getAssets()));

        mFieldSummerView = (FieldSummerView) view.findViewById(R.id.fieldView);

        btnRestart = (ImageView) view.findViewById(R.id.btnRestart);
        btnRestart.setOnClickListener(btnRestartClick);

        btnHelp = (ImageView) view.findViewById(R.id.btnHelp);
        btnHelp.setOnClickListener(btnHelpClick);

        btnMenu = (ImageView) view.findViewById(R.id.btnMenu);
        btnMenu.setOnClickListener(btnMenuClick);

        startGame(level);

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
            startGame(level);
        }
    };

    View.OnClickListener btnHelpClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DialogSummerHelp dialog = new DialogSummerHelp(getActivity());
            dialog.show();
        }
    };

    private void startGame(int level) {
        tvNumberLevel.setText(String.format("%s", level));
        controller = new SummerController(level);
        controller.setOnControllerListener(SummerFragment.this);
        controller.setOnGameListener(SummerFragment.this);

        mFieldSummerView.createField(App.getWidthScreen()*0.96f, controller.getField());
        mFieldSummerView.setOnActionField(this);
    }

    @Override
    public void onWin() {
        Log.d("TAG", "WIN");
        activity.setCurrentSummerLevel(controller.getLevel());
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(App.getSummerLevels().size() > level) {
                    DialogLevelCompletion dialog = new DialogLevelCompletion(activity, new DialogLevelCompletion.OnDialogCompletionListener() {
                        @Override
                        public void onMenu() {
                            activity.onBackPressed();
                        }

                        @Override
                        public void onNextLevel() {
                            level++;
                            startGame(level);
                        }
                    });
                    dialog.show();
                }
            }
        }, 500);
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
