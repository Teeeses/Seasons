package com.explead.twoseasons.views;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.RelativeLayout;

import com.explead.twoseasons.R;
import com.explead.twoseasons.logic.controllers.WinterController;
import com.explead.twoseasons.logic.elements.Cell;

/**
 * Created by Александр on 09.07.2017.
 */

public class CellView extends View {

    public final int[] COLORS_START = {R.drawable.icon_blue_cube, R.drawable.icon_red_cube};
    public final int[] COLORS_END = {R.drawable.icon_inside_blue_cube, R.drawable.icon_inside_red_cube};
    protected Cell cell;

    protected float globalX;
    protected float globalY;

    protected float size;

    protected Drawable image;

    public CellView(Context context) {
        super(context);
    }

    public CellView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CellView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setDate(float size, Cell cell) {
        this.size = size;
        this.cell = cell;
        this.setLayoutParams(new RelativeLayout.LayoutParams((int)(size + 2f), (int)(size + 2f)));
        calculateGlobalValue();
    }

    public void setData(Cell cell) {
        this.cell.setX(cell.getX());
        this.cell.setY(cell.getY());
        calculateGlobalValue();
    }

    public void calculateGlobalValue() {
        globalX = cell.getX()*size;
        globalY = cell.getY()*size;
        this.setX(globalX);
        this.setY(globalY);
    }

    public Cell getCell() {
        return cell;
    }

    public void setBackground(int color) {
        this.setBackgroundColor(color);
    }

    public float coordToGlobal(int coordinate) {
        return coordinate*size;
    }



    public void setAnimationFromPointToPoint(Cell startCell, Cell endCell, final String direction, final WinterController controller) {
        float from;
        float to;

        if (direction.equals("up") || direction.equals("down")) {
            from = coordToGlobal(startCell.getY());
            to = coordToGlobal(endCell.getY());
        } else {
            from = coordToGlobal(startCell.getX());
            to = coordToGlobal(endCell.getX());
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
                controller.setStatus(WinterController.NO_MOVE);
            }
        });
        valueAnimator.setDuration(300);
        controller.setStatus(WinterController.MOVE);
        valueAnimator.start();
    }
}
