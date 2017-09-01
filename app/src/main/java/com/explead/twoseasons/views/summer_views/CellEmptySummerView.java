package com.explead.twoseasons.views.summer_views;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by Александр on 09.07.2017.
 */

public class CellEmptySummerView extends CellSummerView {

    private Context context;

    public CellEmptySummerView(Context context) {
        super(context);
        init(context);
    }

    public CellEmptySummerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CellEmptySummerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        setBackground(Color.WHITE);
    }
}
