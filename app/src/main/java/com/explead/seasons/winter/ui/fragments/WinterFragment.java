package com.explead.seasons.winter.ui.fragments;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.explead.screenmovementfinger.WinterMovementFinger;
import com.explead.seasons.R;
import com.explead.seasons.common.app.App;
import com.explead.seasons.common.beans.AllLevels;
import com.explead.seasons.common.beans.Level;
import com.explead.seasons.common.dialogs.DialogHardIsClosed;
import com.explead.seasons.common.dialogs.DialogMonthIsClosed;
import com.explead.seasons.common.dialogs.DialogWinterHelp;
import com.explead.seasons.common.dialogs.DialogWinterWin;
import com.explead.seasons.common.logic.Direction;
import com.explead.seasons.common.ui.fragments.GameFragment;
import com.explead.seasons.common.utils.Utils;
import com.explead.seasons.winter.logic.FieldWinter;
import com.explead.seasons.winter.ui.WinterGameBar;
import com.explead.seasons.winter.ui.winter_views.FieldWinterView;
import com.explead.seasons.winter.ui.winter_views.SnowfallView;
import com.google.android.material.snackbar.Snackbar;

/**
 * Created by Александр on 09.07.2017.
 */

public class WinterFragment extends GameFragment implements FieldWinter.OnControllerListener, WinterGameBar.OnMenuClickListener {

    private FieldWinterView fieldView;
    private int level;

    private SnowfallView snowfall;
    private WinterGameBar bar;
    private FieldWinter fieldWinter;

    private SoundPool soundPoolWin;
    private SoundPool soundPoolMove;

    private AllLevels.Month month;
    private AllLevels.Complication complication = AllLevels.Complication.EASY;

    private RelativeLayout containerEasyLevel;
    private RelativeLayout containerHardLevel;

    private View view;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_winter, container, false);

        soundPoolMove = new SoundPool(1, AudioManager.STREAM_MUSIC, 100);
        soundPoolWin = new SoundPool(1, AudioManager.STREAM_MUSIC, 100);
        soundPoolWin.load(getActivity(), R.raw.sound_win, 1);
        soundPoolMove.load(getActivity(), R.raw.move, 1);

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
        } else if(month == AllLevels.Month.JANUARY && !App.getSaverSpref().isLevelCompliated(AllLevels.Month.DECEMBER, Level.LEVEL_NEXT_MODE)) {
            openDialogMonthIsClosed();
        }
    }

    private WinterMovementFinger.OnSideFingerMovementCallback onSideFingerMovementCallback =
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
        final DialogMonthIsClosed dialog = new DialogMonthIsClosed(requireActivity(), () -> activity.onBackPressed());
        dialog.show();
    }

    private void openHelpDialog() {
        DialogWinterHelp dialog = new DialogWinterHelp(requireActivity());
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
        DialogWinterHelp dialog = new DialogWinterHelp(requireActivity());
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
        checkOpenedMode(level);
        App.getSaverSpref().saveCurrentLevel(level, month, complication);
        soundPoolWin.play(1, 0.2f, 0.2f, 1, 0, 1f);
        new Handler().postDelayed(() -> {
            DialogWinterWin dialog = new DialogWinterWin(activity, onDialogCompletionListener, complication, month, level);
            dialog.show();
        }, 500);
        activity.sendEventWinGame(level, month, complication);
    }

    private void checkOpenedMode(int level) {
        if(level == Level.LEVEL_NEXT_MODE && !App.getSaverSpref().isLevelCompliated(AllLevels.Month.DECEMBER, level)) {
            showSnackBarOpenNewMode();
        }
    }

    @Override
    public void onFirstMove() {
        soundPoolMove.play(1, 0.2f, 0.2f, 1, 0, 1f);
    }

    private void startGame(int level, AllLevels.Month month, AllLevels.Complication complication) {
        activity.sendEventStartGame(level, month, complication);
        bar.setNumberLevel(level);

        fieldWinter = new FieldWinter(level, month, complication);
        fieldWinter.setOnControllerListener(this);
        fieldView.setFieldWinter(fieldWinter);

        fieldView.clearField();
        fieldView.createField();
    }

    private View.OnClickListener changeOnEasy = v -> changeOmEasy();

    private View.OnClickListener changeOnHard = v -> changeOnHard();

    private void changeOmEasy() {
        containerEasyLevel.setVisibility(View.GONE);
        containerHardLevel.setVisibility(View.VISIBLE);
        complication = AllLevels.Complication.EASY;
        startGame(level, month, complication);
    }

    private void changeOnHard() {
        if(!App.getSaverSpref().isLevelCompliated(month, level)) {
            DialogHardIsClosed dialogHardClosed = new DialogHardIsClosed(activity);
            dialogHardClosed.show();
        }
        else {
            containerHardLevel.setVisibility(View.GONE);
            containerEasyLevel.setVisibility(View.VISIBLE);
            complication = AllLevels.Complication.HARD;
            startGame(level, month, complication);
        }
    }

    private void showSnackBarOpenNewMode() {
        if(view != null) {
            Snackbar sb = Snackbar.make(view,
                    String.format(activity.getResources().getString(R.string.open_new_mode), activity.getResources().getString(R.string.january)),
                    Snackbar.LENGTH_LONG);
            View view = sb.getView();
            TextView tv = view.findViewById(R.id.snackbar_text);
            tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tv.setGravity(Gravity.CENTER_HORIZONTAL);
            tv.setTypeface(Utils.getTypeFaceLevel(activity.getAssets()));
            sb.show();
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
