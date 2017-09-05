package com.explead.twoseasons.views.summer_views;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.explead.twoseasons.R;
import com.explead.twoseasons.logic.controllers.WinterController;
import com.explead.twoseasons.logic.elements.Cell;

/**
 * Created by Александр on 09.07.2017.
 */

public class CellSummerView extends View {

    public final int[] COLORS = {Color.BLUE, Color.RED, Color.MAGENTA, Color.YELLOW, Color.GREEN};
    protected Cell cell;

    protected float globalX;
    protected float globalY;

    protected float size;

    protected Drawable image;

    public CellSummerView(Context context) {
        super(context);
    }

    public CellSummerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CellSummerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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

}
