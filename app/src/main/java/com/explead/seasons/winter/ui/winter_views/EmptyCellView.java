package com.explead.seasons.winter.ui.winter_views;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;

public class EmptyCellView extends BaseView {

    public EmptyCellView(Context context) {
        super(context);
        create();
    }

    public EmptyCellView(Context context, AttributeSet attrs) {
        super(context, attrs);
        create();
    }

    public EmptyCellView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        create();
    }

    private void create() {
        setBackground(Color.rgb(202, 202, 202));
    }
}