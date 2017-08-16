package com.explead.twoseasons.views.winter_views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by Александр on 09.07.2017.
 */

public class CellStartWinterView extends CellWinterView {

    private Context context;
    private int id;

    public CellStartWinterView(Context context) {
        super(context);
        init(context);
    }

    public CellStartWinterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CellStartWinterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
        setBackgroundDrawable(context.getResources().getDrawable(COLORS_START[id]));
    }
}
