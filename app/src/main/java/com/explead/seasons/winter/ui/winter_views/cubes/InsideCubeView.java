package com.explead.seasons.winter.ui.winter_views.cubes;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.explead.seasons.R;
import com.explead.seasons.winter.logic.WinterCell;

public class InsideCubeView extends BaseCubeView {

    public InsideCubeView(Context context) {
        super(context);
    }

    public InsideCubeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public InsideCubeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void create(WinterCell.ColorCube color) {
        this.colorCube = color;
        findDrawable();
        setBackground();
    }

    public void findDrawable() {
        if(colorCube == WinterCell.ColorCube.RED) {
            background = R.drawable.icon_inside_red_cube;
        }
        if(colorCube == WinterCell.ColorCube.BLUE) {
            background = R.drawable.icon_inside_blue_cube;
        }
        if(colorCube == WinterCell.ColorCube.YELLOW) {
            background = R.drawable.icon_inside_yellow_cube;
        }
    }


}
