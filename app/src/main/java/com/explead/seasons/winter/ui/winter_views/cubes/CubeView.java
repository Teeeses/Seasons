package com.explead.seasons.winter.ui.winter_views.cubes;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.explead.seasons.R;
import com.explead.seasons.winter.logic.WinterCell;

public class CubeView extends BaseCubeView {

    protected WinterCell insideCell;

    public CubeView(Context context) {
        super(context);
    }

    public CubeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CubeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setAnimationFromPointToPoint(WinterCell startCell, final WinterCell endCell, final String direction) {
        float from, to;

        if (direction.equals("up") || direction.equals("down")) {
            from = coordToGlobal(startCell.getX());
            to = coordToGlobal(endCell.getX());
        } else {
            from = coordToGlobal(startCell.getY());
            to = coordToGlobal(endCell.getY());
        }

        final View view = this;
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(from, to);

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                if(direction.equals("up") || direction.equals("down")) {
                    view.setTranslationY(value);
                } else {
                    view.setTranslationX(value);
                }
            }
        });

        valueAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {}
            @Override
            public void onAnimationCancel(Animator animator) {}
            @Override
            public void onAnimationRepeat(Animator animator) {}
            @Override
            public void onAnimationEnd(Animator animator) {
            }
        });
        valueAnimator.setDuration(200);
        valueAnimator.start();
    }

    public WinterCell getInsideCell() {
        return insideCell;
    }

    public void setInsideCell(WinterCell insideCell) {
        this.insideCell = insideCell;
    }

    public void create(WinterCell.ColorCube color) {
        this.colorCube = color;
        findDrawable();
        setBackground();
    }

    public void findDrawable() {
        if(colorCube == WinterCell.ColorCube.RED) {
            background = R.drawable.icon_red_cube;
        }
        if(colorCube == WinterCell.ColorCube.BLUE) {
            background = R.drawable.icon_blue_cube;
        }
        if(colorCube == WinterCell.ColorCube.YELLOW) {
            background = R.drawable.icon_yellow_cube;
        }
    }
}
