package com.explead.seasons.winter.ui.winter_views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;

import com.explead.seasons.common.beans.GetIds;
import com.explead.seasons.common.ui.CellView;
import com.explead.seasons.winter.interfaces.OnMoveCubeListener;
import com.explead.seasons.winter.logic.WinterMember;

import java.util.ArrayList;

public class CubeView extends CellView implements OnMoveCubeListener {

    protected WinterMember cell;
    private ArrayList<ValueAnimator> animationQueue = new ArrayList<>();

    private final int DURATION = 300;

    public CubeView(Context context) {
        super(context);
        init(context);
    }

    public CubeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CubeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
    }

    public void create(float size, WinterMember cell) {
        this.size = size;
        this.cell = cell;
        cell.setOnMoveListener(this);
        this.setLayoutParams(new RelativeLayout.LayoutParams((int)(size + 2f), (int)(size + 2f)));
        calculateGlobalValue(cell.getX(), cell.getY());
        this.setBackgroundDrawable(context.getResources().getDrawable(GetIds.getIdWinterCubeFromColor(cell.getColor())));
    }

    @Override
    public void onUp(int from_, int to_) {
        float from = coordinateToGlobal(from_);
        float to = coordinateToGlobal(to_);
        setAnimationFromPointToPoint(from, to, "up");
    }

    @Override
    public void onDown(int from_, int to_) {
        float from = coordinateToGlobal(from_);
        float to = coordinateToGlobal(to_);
        setAnimationFromPointToPoint(from, to, "down");
    }

    @Override
    public void onRight(int from_, int to_) {
        float from = coordinateToGlobal(from_);
        float to = coordinateToGlobal(to_);
        setAnimationFromPointToPoint(from, to, "right");
    }

    @Override
    public void onLeft(int from_, int to_) {
        float from = coordinateToGlobal(from_);
        float to = coordinateToGlobal(to_);
        setAnimationFromPointToPoint(from, to, "left");
    }

    public void setAnimationFromPointToPoint(float from, float to, final String direction) {

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
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                animationQueue.remove(0);
                if(animationQueue.size() != 0) {
                    animationQueue.get(0).start();
                } else {
                    cell.setMOVE(false);
                    cell.onFirstMove();
                }
            }
        });
        valueAnimator.setDuration(DURATION);

        if(animationQueue.size() == 0) {
            cell.setMOVE(true);
            valueAnimator.start();
        }
        animationQueue.add(valueAnimator);
    }

    public WinterMember getCell() {
        return cell;
    }
}
