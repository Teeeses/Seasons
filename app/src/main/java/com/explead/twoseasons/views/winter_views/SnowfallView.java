package com.explead.twoseasons.views.winter_views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.provider.SyncStateContract;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.explead.twoseasons.R;
import com.explead.twoseasons.app.App;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by develop on 15.09.2017.
 */

public class SnowfallView  extends RelativeLayout {

    private Context context;
    private RelativeLayout root;

    public static final int EMPTY_MESSAGE_WHAT = 0x001;

    private int[] SNOWFLAKE = {R.drawable.snow};
    private ArrayList<View> allImageViews = new ArrayList<>();

    public SnowfallView(Context context) {
        super(context);
        init(context);
    }

    public SnowfallView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SnowfallView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        root = this;

        new Timer().schedule(new ExeTimerTask(), 0, 200);
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //int viewId = new Random().nextInt(SNOWFLAKE.length);
            Drawable d = getResources().getDrawable(R.drawable.snow);

            LayoutInflater inflate = LayoutInflater.from(context);
            ImageView imageView = (ImageView) inflate.inflate(R.layout.snowflake, null, false);
            imageView.setImageDrawable(d);
            imageView.setLayoutParams(new LayoutParams(30, 30));
            root.addView(imageView);

            allImageViews.add(imageView);

            startAnimation(imageView);
        }
    };

    public void startAnimation(final ImageView aniView) {

        aniView.setX(new Random().nextInt((int)App.getWidthScreen()));

        final ValueAnimator animator = ValueAnimator.ofFloat(-100, App.getHeightScreen());
        animator.setDuration(5000);
        animator.setInterpolator(new AccelerateInterpolator());

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();

                aniView.setTranslationY(value);
            }
        });

        animator.start();
    }

    private class ExeTimerTask extends TimerTask {
        @Override
        public void run() {
            mHandler.sendEmptyMessage(EMPTY_MESSAGE_WHAT);
        }
    }
}
