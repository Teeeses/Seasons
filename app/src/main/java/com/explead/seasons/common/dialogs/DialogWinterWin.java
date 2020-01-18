package com.explead.seasons.common.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.explead.seasons.R;
import com.explead.seasons.common.beans.AllLevels;
import com.explead.seasons.common.interfaces.OnDialogCompletionListener;
import com.explead.seasons.common.utils.Utils;

public class DialogWinterWin extends Dialog {

    private OnDialogCompletionListener mOnDialogCompletionListener;

    private Context context;
    private AllLevels.Complication complication;
    private AllLevels.Month month;
    private int level;

    public DialogWinterWin(@NonNull Context context, OnDialogCompletionListener mOnDialogCompletionListener,
                           AllLevels.Complication complication, AllLevels.Month month, int level) {
        super(context);
        this.context = context;
        this.complication = complication;
        this.month = month;
        this.level = level;
        this.mOnDialogCompletionListener = mOnDialogCompletionListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_winter_win);

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.MATCH_PARENT;
        getWindow().setAttributes(params);

        Drawable drawable = new ColorDrawable(Color.BLACK);
        drawable.setAlpha(50);
        getWindow().setBackgroundDrawable(drawable);

        ImageView imageLuminescence = findViewById(R.id.imageLuminescence);
        imageLuminescence.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.anim_luminescence));

        TextView textCompleted = findViewById(R.id.textCompleted);
        textCompleted.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.anim_text_completed));

        ImageView imageCompleted = findViewById(R.id.imageCompleted);
        imageCompleted.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.anim_image_win_cube));

        ImageView btnMenu = findViewById(R.id.btnMenu);
        btnMenu.setOnClickListener(view -> {
            mOnDialogCompletionListener.onMenu();
            dismiss();
        });

        ImageView btnNextLevel = findViewById(R.id.btnNextLevel);
        btnNextLevel.setOnClickListener(view -> {
            mOnDialogCompletionListener.onNextLevel();
            dismiss();
        });
        if(level >= month.getDeis()) {
            btnNextLevel.setVisibility(View.GONE);
        }

        ImageView btnHardLevel = findViewById(R.id.btnHardLevel);
        btnHardLevel.setOnClickListener(view -> {
            mOnDialogCompletionListener.onHardLevel();
            dismiss();
        });
        View container = findViewById(R.id.containerBtnHardLevel);
        if(complication == AllLevels.Complication.HARD) {
            container.setVisibility(View.GONE);
        }

        btnMenu.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.anim_buttons_win));
        btnNextLevel.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.anim_buttons_win));
        btnHardLevel.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.anim_buttons_win));
    }

    @Override
    public void onBackPressed() {
        mOnDialogCompletionListener.onMenu();
        super.onBackPressed();

    }
}