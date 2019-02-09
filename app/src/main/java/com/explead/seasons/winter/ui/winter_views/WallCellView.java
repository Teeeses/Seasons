package com.explead.seasons.winter.ui.winter_views;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;

public class WallCellView extends BaseView {

    public WallCellView(Context context) {
        super(context);
        create();
    }

    public WallCellView(Context context, AttributeSet attrs) {
        super(context, attrs);
        create();
    }

    public WallCellView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        create();
    }

    private void create() {
        setBackground(Color.TRANSPARENT);
    }
}
