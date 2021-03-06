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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.explead.seasons.R;

/**
 * Created by develop on 11.09.2017.
 */

public class DialogWinterHelp extends Dialog {

    private Context context;
    private ImageView imageFingerHelp;
    private Animation animation;

    public DialogWinterHelp(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_winter_help);

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        getWindow().setAttributes(params);

        Drawable drawable = new ColorDrawable(Color.BLACK);
        drawable.setAlpha(100);
        getWindow().setBackgroundDrawable(drawable);

        imageFingerHelp = findViewById(R.id.imageFingerHelp);
        animation = AnimationUtils.loadAnimation(getContext(), R.anim.anim_finger_help);
        imageFingerHelp.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationEnd(Animation arg0) {
                animation.setAnimationListener(this);
                imageFingerHelp.startAnimation(animation);
            }
            @Override
            public void onAnimationRepeat(Animation arg0) {}
            @Override
            public void onAnimationStart(Animation arg0) {}
        });

        TextView tvClose = findViewById(R.id.tvClose);
        tvClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    @Override
    public void onBackPressed() {
        animation.cancel();
        super.onBackPressed();
    }

    @Override
    public void dismiss() {
        animation.cancel();
        super.dismiss();
    }
}