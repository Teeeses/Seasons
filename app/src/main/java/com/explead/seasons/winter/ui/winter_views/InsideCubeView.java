package com.explead.seasons.winter.ui.winter_views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;

import com.explead.seasons.common.beans.GetIds;
import com.explead.seasons.common.ui.CellView;

public class InsideCubeView extends CellView {

    private Context context;
    private WinterInsideCube cell;

    public InsideCubeView(Context context) {
        super(context);
        init(context);
    }

    public InsideCubeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public InsideCubeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
    }

    public void create(float size, WinterInsideCube cell) {
        this.size = size;
        this.cell = cell;
        this.setLayoutParams(new RelativeLayout.LayoutParams((int)(size + 2f), (int)(size + 2f)));
        calculateGlobalValue(cell.getX(), cell.getY());
        this.setBackgroundDrawable(context.getResources().getDrawable(GetIds.getIdWinterInsideCubeFromColor(cell.getColor())));
    }

    public WinterInsideCube getCell() {
        return cell;
    }
}
