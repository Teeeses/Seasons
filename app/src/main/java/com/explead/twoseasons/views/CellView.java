package com.explead.twoseasons.views;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;

import com.explead.twoseasons.R;
import com.explead.twoseasons.logic.elements.Cell;
import com.explead.twoseasons.logic.elements.StartCell;

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

    public void setAnimationFromPointToPoint(Cell startCell, Cell endCell) {
        if(!startCell.equals(endCell)) {
            float fromX = coordToGlobal(startCell.getX());
            float toX = coordToGlobal(endCell.getX());
            float fromY = coordToGlobal(startCell.getY());
            float toY = coordToGlobal(endCell.getY());
            TranslateAnimation animation = new TranslateAnimation(fromX, toX, fromY, toY);
            animation.setDuration(5000);
            animation.setAnimationListener(new MyAnimationListener(this, startCell, endCell));
            this.startAnimation(animation);
        }
    }

    private class MyAnimationListener implements Animation.AnimationListener {

        private CellView cellView;
        private Cell startCell;
        private Cell endCell;

        public MyAnimationListener(CellView cellView, Cell startCell, Cell endCell) {
            this.cellView = cellView;
            this.startCell = startCell;
            this.endCell = endCell;
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            cellView.setData(endCell);
        }
        @Override
        public void onAnimationRepeat(Animation animation) {}
        @Override
        public void onAnimationStart(Animation animation) {}
    }
}
