package com.explead.seasons.winter.ui.winter_views.cubes;

import android.content.Context;
import android.util.AttributeSet;

import com.explead.seasons.winter.logic.WinterCell;
import com.explead.seasons.winter.ui.winter_views.BaseView;

public class BaseCubeView extends BaseView {

    protected WinterCell.ColorCube colorCube;

    public BaseCubeView(Context context) {
        super(context);
    }

    public BaseCubeView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseCubeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
