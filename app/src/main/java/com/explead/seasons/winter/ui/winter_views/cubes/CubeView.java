package com.explead.seasons.winter.ui.winter_views.cubes;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.explead.seasons.common.beans.GetIds;
import com.explead.seasons.common.ui.CellView;
import com.explead.seasons.winter.logic.WinterCube;

public class CubeView extends CellView implements WinterCube.OnMoveListener {

    protected WinterCube cell;

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

    public void create(float size, WinterCube cell) {
        this.size = size;
        this.cell = cell;
        cell.setOnMoveListener(this);
        this.setLayoutParams(new RelativeLayout.LayoutParams((int)(size + 2f), (int)(size + 2f)));
        calculateGlobalValue(cell.getX(), cell.getY());
        this.setBackgroundDrawable(context.getResources().getDrawable(GetIds.getIdWinterCubeFromColor(cell.getColor())));
    }

    @Override
    public void onUp(int x, int y) {
        float from = coordinateToGlobal(cell.getX());
        float to = coordinateToGlobal(x);
        setAnimationFromPointToPoint(from, to, "up");
        cell.setX(x);
        cell.setY(y);
    }

    @Override
    public void onDown(int x, int y) {
        float from = coordinateToGlobal(cell.getX());
        float to = coordinateToGlobal(x);
        setAnimationFromPointToPoint(from, to, "down");
        cell.setX(x);
        cell.setY(y);
    }

    @Override
    public void onRight(int x, int y) {
        float from = coordinateToGlobal(cell.getY());
        float to = coordinateToGlobal(y);
        setAnimationFromPointToPoint(from, to, "right");
        cell.setX(x);
        cell.setY(y);
    }

    @Override
    public void onLeft(int x, int y) {
        float from = coordinateToGlobal(cell.getY());
        float to = coordinateToGlobal(y);
        setAnimationFromPointToPoint(from, to, "left");
        cell.setX(x);
        cell.setY(y);
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

        valueAnimator.setDuration(200);
        valueAnimator.start();
    }
}
