package com.explead.twoseasons.views.summer_views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by Александр on 09.07.2017.
 */

public class CellEndSummerView extends CellSummerView {

    private Context context;
    private int id;

    public CellEndSummerView(Context context) {
        super(context);
        init(context);
    }

    public CellEndSummerView(Context context, int id) {
        super(context);
        init(context, id);
    }

    public CellEndSummerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CellEndSummerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
    }

    private void init(Context context, int id) {
        this.context = context;
        setId(id);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
        setBackgroundColor(COLORS[id]);
    }
}
