package com.explead.seasons.winter.ui.fragments;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.explead.screenmovementfinger.WinterMovementFinger;
import com.explead.seasons.R;
import com.explead.seasons.common.app.App;
import com.explead.seasons.common.dialogs.DialogWinterHelp;
import com.explead.seasons.common.dialogs.DialogWinterWin;
import com.explead.seasons.common.ui.fragments.GameFragment;
import com.explead.seasons.winter.logic.WinterCell;
import com.explead.seasons.winter.logic.FieldWinter;
import com.explead.seasons.winter.ui.WinterGameBar;
import com.explead.seasons.winter.ui.winter_views.FieldWinterView;
import com.explead.seasons.winter.ui.winter_views.SnowfallView;

/**
 * Created by Александр on 09.07.2017.
 */

public class WinterFragment extends GameFragment implements FieldWinter.OnControllerListener, WinterGameBar.OnMenuClickListener {

    private FieldWinterView fieldView;
    private int level;

    private SnowfallView snowfall;
    private WinterGameBar bar;

    private SoundPool soundPool;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_winter, container, false);

        soundPool = new SoundPool(4, AudioManager.STREAM_MUSIC, 100);
        soundPool.load(getActivity(), R.raw.sound_win, 1);
        soundPool.load(getActivity(), R.raw.sound_move_cube, 2);

        snowfall = view.findViewById(R.id.snowfall);
        snowfall.setPeriodicityCreateSnowflake(400, 800);
        snowfall.setPeriodicityCreateCloud(15000);
        snowfall.startAnimation();

        level = getArguments().getInt("level");
        if(level == 1) {
            openHelpDialog();
        }

        bar = view.findViewById(R.id.gameBar);
        bar.setOnMenuClickListener(this);

        fieldView = view.findViewById(R.id.fieldView);

        startGame(level);

        WinterMovementFinger winterMovementFinger = new WinterMovementFinger(onSideFingerMovementCallback);
        winterMovementFinger.setTouchView(view);

        return view;
    }

    public WinterMovementFinger.OnSideFingerMovementCallback onSideFingerMovementCallback =
            new WinterMovementFinger.OnSideFingerMovementCallback() {
        @Override
        public void onUp() {
            fieldView.getController().moveUp();
            checkWin();
        }

        @Override
        public void onDown() {
            fieldView.getController().moveDown();
            checkWin();
        }

        @Override
        public void onRight() {
            fieldView.getController().moveRight();
            checkWin();
        }

        @Override
        public void onLeft() {
            fieldView.getController().moveLeft();
            checkWin();
        }
    };

    private void checkWin() {
        if(fieldView.checkWin()) {
            soundPool.play(1, 1f, 1f, 1, 0, 1f);
            activity.setCurrentWinterLevel(level);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(App.getWinterLevels().size() > level) {
                        DialogWinterWin dialog = new DialogWinterWin(activity, onDialogCompletionListener);
                        dialog.show();
                    }
                }
            }, 500);
        }
    }

    private void openHelpDialog() {
        DialogWinterHelp dialog = new DialogWinterHelp(getActivity());
        dialog.show();
    }

    @Override
    public void onMenu() {
        activity.onBackPressed();
    }

    @Override
    public void onRestart() {
        fieldView.clearField();
        startGame(level);
    }

    @Override
    public void onHelp() {
        DialogWinterHelp dialog = new DialogWinterHelp(getActivity());
        dialog.show();
    }

    private DialogWinterWin.OnDialogCompletionListener onDialogCompletionListener =
            new DialogWinterWin.OnDialogCompletionListener() {
        @Override
        public void onMenu() {
            activity.onBackPressed();
        }

        @Override
        public void onNextLevel() {
            level++;
            startGame(level);
        }
    };

    @Override
    public void onChangeCell(final WinterCell cell, final WinterCell newCell, final String direction) {
        soundPool.play(2, 0.1f, 0.1f, 1, 0, 1f);
        fieldView.startAnimation(cell, newCell, direction);

    }

    public void startGame(int level) {
        bar.setNumberLevel(level);

        fieldView.setController(level);
        fieldView.getController().setOnControllerListener(this);
        fieldView.clearField();
        fieldView.createField(App.getWidthScreen()*0.96f);
    }

    @Override
    public void onDestroy() {
        snowfall.stopAnimation();
        super.onDestroy();
    }
}
