package com.explead.twoseasons.views.summer_views;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by Александр on 09.07.2017.
 */

public class CellWallSummerView extends CellSummerView {

    private Context context;

    public CellWallSummerView(Context context) {
        super(context);
        init(context);
    }

    public CellWallSummerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CellWallSummerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        setBackground(Color.TRANSPARENT);
    }
}