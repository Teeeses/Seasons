package com.explead.seasons.winter.ui.winter_views;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.explead.seasons.R;
import com.explead.seasons.common.ui.CellView;
import com.explead.seasons.winter.logic.WinterCell;

public class WinterCellView extends CellView {

    protected int id;
    private WinterCell cell;

    public WinterCellView(Context context) {
        super(context);
        init(context);
    }

    public WinterCellView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public WinterCellView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    protected void init(Context context) {
        this.context = context;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public void create(float size, WinterCell cell) {
        this.size = size;
        this.cell = cell;
        this.setLayoutParams(new RelativeLayout.LayoutParams((int)(size + 2f), (int)(size + 2f)));
        calculateGlobalValue(cell.getX(), cell.getY());
        setBackground();
    }


    public WinterCell getCell() {
        return cell;
    }

    protected void setBackground() {
        if(cell.getPurpose() == WinterCell.PurposeCell.EMPTY) {
            boolean value = ((cell.getX() + cell.getY()) % 2) == 0;
            if(value) {
                setBackground(context.getResources().getColor(R.color.cell_light));
            } else {
                setBackground(context.getResources().getColor(R.color.cell_dark));
            }
        }
        if(cell.getPurpose() == WinterCell.PurposeCell.WALL) {
            setBackground(Color.TRANSPARENT);
        }
    }

    public void setBackground(int color) {
        this.setBackgroundColor(color);
    }

}
