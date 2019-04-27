package com.explead.seasons.winter.ui.fragments;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.explead.screenmovementfinger.WinterMovementFinger;
import com.explead.seasons.R;
import com.explead.seasons.common.app.App;
import com.explead.seasons.common.beans.AllLevels;
import com.explead.seasons.common.dialogs.DialogHardIsClosed;
import com.explead.seasons.common.dialogs.DialogMonthIsClosed;
import com.explead.seasons.common.dialogs.DialogWinterHelp;
import com.explead.seasons.common.dialogs.DialogWinterWin;
import com.explead.seasons.common.interfaces.OnClosedCallback;
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

    private RelativeLayout containerEasyLevel;
    private RelativeLayout containerHardLevel;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_winter, container, false);

        soundPool = new SoundPool(4, AudioManager.STREAM_MUSIC, 100);
        soundPool.load(getActivity(), R.raw.sound_win, 1);
        soundPool.load(getActivity(), R.raw.sound_move_cube_two, 2);

        containerEasyLevel = view.findViewById(R.id.containerEasyLevel);
        containerEasyLevel.setOnClickListener(changeOnEasy);
        containerHardLevel = view.findViewById(R.id.containerHardLevel);
        containerHardLevel.setOnClickListener(changeOnHard);

        snowfall = view.findViewById(R.id.snowfall);
        snowfall.setPeriodicityCreateSnowflake(400, 800);
        snowfall.setPeriodicityCreateCloud(15000);

        level = getArguments().getInt("level");
        month = (AllLevels.Month) getArguments().get("month");

        bar = view.findViewById(R.id.gameBar);
        bar.setOnMenuClickListener(this);

        fieldView = view.findViewById(R.id.fieldView);

        startGame(level, month, complication);

        WinterMovementFinger winterMovementFinger = new WinterMovementFinger(onSideFingerMovementCallback);
        winterMovementFinger.setTouchView(view);

        checkOnDialogs();

        return view;
    }

    private void checkOnDialogs() {
        if(level == 1 && month == AllLevels.Month.DECEMBER) {
            openHelpDialog();
        } else if(month == AllLevels.Month.JANUARY && !App.getSaverSpref().isLevelCompliated(AllLevels.Month.DECEMBER, 15)) {
            openDialogMonthIsClosed();
        }
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

    private void openDialogMonthIsClosed() {
        final DialogMonthIsClosed dialog = new DialogMonthIsClosed(getActivity(), new OnClosedCallback() {
            @Override
            public void onClosed() {
                activity.onBackPressed();
            }
        });
        dialog.show();
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
            changeOmEasy();
        }

        @Override
        public void onHardLevel() {
            changeOnHard();
        }
    };

    @Override
    public void onWin() {
        App.getSaverSpref().saveCurrentLevel(level, month, complication);
        soundPool.play(1, 0.2f, 0.2f, 1, 0, 1f);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                DialogWinterWin dialog = new DialogWinterWin(activity, onDialogCompletionListener, complication, month, level);
                dialog.show();
            }
        }, 500);
    }

    @Override
    public void onFirstMove() {
        //soundPool.play(2, 1f, 1f, 1, 0, 1f);
    }

    public void startGame(int level, AllLevels.Month month, AllLevels.Complication complication) {
        bar.setNumberLevel(level);

        fieldWinter = new FieldWinter(level, month, complication);
        fieldWinter.setOnControllerListener(this);
        fieldView.setFieldWinter(fieldWinter);

        fieldView.clearField();
        fieldView.createField();
    }

    private View.OnClickListener changeOnEasy = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            changeOmEasy();
        }
    };

    private View.OnClickListener changeOnHard = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            changeOnHard();
        }
    };

    private void changeOmEasy() {
        containerEasyLevel.setVisibility(View.GONE);
        containerHardLevel.setVisibility(View.VISIBLE);
        complication = AllLevels.Complication.EASY;
        startGame(level, month, complication);
    }

    private void changeOnHard() {
        if(!App.getSaverSpref().isLevelCompliated(month, level)) {
            DialogHardIsClosed dialogHardClosed = new DialogHardIsClosed(getActivity());
            dialogHardClosed.show();
        }
        else {
            containerHardLevel.setVisibility(View.GONE);
            containerEasyLevel.setVisibility(View.VISIBLE);
            complication = AllLevels.Complication.HARD;
            startGame(level, month, complication);
        }
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
