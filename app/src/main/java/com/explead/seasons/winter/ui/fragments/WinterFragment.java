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
import com.explead.seasons.common.beans.AllLevels;
import com.explead.seasons.common.dialogs.DialogWinterHelp;
import com.explead.seasons.common.dialogs.DialogWinterWin;
import com.explead.seasons.common.logic.Direction;
import com.explead.seasons.common.ui.fragments.GameFragment;
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
    private FieldWinter fieldWinter;

    private SoundPool soundPool;

    private AllLevels.Month month;
    private AllLevels.Complication complication = AllLevels.Complication.EASY;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_winter, container, false);

        soundPool = new SoundPool(4, AudioManager.STREAM_MUSIC, 100);
        soundPool.load(getActivity(), R.raw.sound_win, 1);
        soundPool.load(getActivity(), R.raw.sound_move_cube, 2);

        snowfall = view.findViewById(R.id.snowfall);
        snowfall.setPeriodicityCreateSnowflake(400, 800);
        snowfall.setPeriodicityCreateCloud(15000);

        level = getArguments().getInt("level");
        month = (AllLevels.Month) getArguments().get("month");
        if(level == 1) {
            openHelpDialog();
        }

        bar = view.findViewById(R.id.gameBar);
        bar.setOnMenuClickListener(this);

        fieldView = view.findViewById(R.id.fieldView);

        startGame(level, month, complication);

        WinterMovementFinger winterMovementFinger = new WinterMovementFinger(onSideFingerMovementCallback);
        winterMovementFinger.setTouchView(view);

        return view;
    }

    public WinterMovementFinger.OnSideFingerMovementCallback onSideFingerMovementCallback =
            new WinterMovementFinger.OnSideFingerMovementCallback() {
        @Override
        public void onUp() {
            fieldWinter.move(Direction.U);
        }

        @Override
        public void onDown() {
            fieldWinter.move(Direction.D);
        }

        @Override
        public void onRight() {
            fieldWinter.move(Direction.R);
        }

        @Override
        public void onLeft() {
            fieldWinter.move(Direction.L);
        }
    };

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
        startGame(level, month, complication);
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
            startGame(level, month, AllLevels.Complication.EASY);
            complication = AllLevels.Complication.EASY;
        }
    };

    @Override
    public void onWin() {
        App.getSaverSpref().saveCurrentLevel(level, month, complication);
        soundPool.play(1, 1f, 1f, 1, 0, 1f);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(month.getDeis() > level) {
                    DialogWinterWin dialog = new DialogWinterWin(activity, onDialogCompletionListener);
                    dialog.show();
                }
            }
        }, 500);
    }

    public void startGame(int level, AllLevels.Month month, AllLevels.Complication complication) {
        bar.setNumberLevel(level);

        fieldWinter = new FieldWinter(level, month, complication);
        fieldWinter.setOnControllerListener(this);
        fieldView.setFieldWinter(fieldWinter);

        fieldView.clearField();
        fieldView.createField();
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
        snowfall.stopAnimation();
        super.onDestroy();
    }
}
