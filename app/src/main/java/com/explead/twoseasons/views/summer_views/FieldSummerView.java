package com.explead.twoseasons.views.summer_views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import com.explead.twoseasons.logic.elements.Cell;
import com.explead.twoseasons.logic.elements.ContainerCells;
import com.explead.twoseasons.logic.elements.EmptyCell;
import com.explead.twoseasons.logic.elements.Field;
import com.explead.twoseasons.logic.elements.WallCell;
import com.explead.twoseasons.views.winter_views.CellEndWinterView;
import com.explead.twoseasons.views.winter_views.CellStartWinterView;
import com.explead.twoseasons.views.winter_views.CellWinterView;
import com.explead.twoseasons.views.winter_views.CellWallWinterView;
import com.explead.twoseasons.views.winter_views.CellEmptyWinterView;

import java.util.ArrayList;

/**
 * Created by Александр on 09.07.2017.
 */

public class FieldSummerView extends RelativeLayout {

    public interface OnActionField {
        void onUp(int x, int y);
        void onMove(int x, int y);
        void onDown(int x, int y);
    }

    private OnActionField onActionField;
    private Context context;

    private ArrayList<CellSummerView> mCellWinterViews = new ArrayList<>();

    private float size;
    private Field field;

    public FieldSummerView(Context context) {
        super(context);
        init(context);
    }

    public FieldSummerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public FieldSummerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
    }

    public void setOnTouch() {
        this.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        final int x = (int) (event.getX() / field.getSizeField());
                        final int y = (int) (event.getY() / field.getSizeField());
                        Cell cell = findTouchCell(x, y);
                        if(cell != null) {
                            Log.d("TAG", "DOWN: " + x + " " + y);
                            //onActionField.onDown(x, y);
                        }
                        break;
                    }
                    case MotionEvent.ACTION_MOVE: {
                        final int x = (int) (event.getX() / field.getSizeField());
                        final int y = (int) (event.getY() / field.getSizeField());
                        Cell cell = findTouchCell(x, y);
                        if(cell != null) {
                            Log.d("TAG", "MOVE: " + x + " " + y);
                            //onActionField.onMove(x, y);
                        }
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        final int x = (int) (event.getX() / field.getSizeField());
                        final int y = (int) (event.getY() / field.getSizeField());
                        Cell cell = findTouchCell(x, y);
                        if(cell != null) {
                            Log.d("TAG", "UP: " + x + " " + y);
                            //onActionField.onUp(x, y);
                        }
                        break;
                    }
                    default:
                        break;
                }
                return true;
            }
        });
    }

    public void changePath(ArrayList<ArrayList<Cell>> result) {

    }

    public void setOnActionField(OnActionField onActionField) {
        this.onActionField = onActionField;
    }

    /**
     * Создаем поле игры
     * @param size - размер поля
     * @param field - данные для построения
     */
    public void createField(float size, Field field) {
        this.size = size;
        this.field = field;

        RelativeLayout.LayoutParams params = new LayoutParams((int)size, (int)size);
        params.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        this.setLayoutParams(params);

        float sizeCell = size/field.getSizeField();

        ArrayList<EmptyCell> emptyCells = field.getEmptyCells();
        for(int i = 0; i < emptyCells.size(); i++) {
            CellEmptySummerView cellEmpty = new CellEmptySummerView(context);
            cellEmpty.setDate(sizeCell, emptyCells.get(i));
            mCellWinterViews.add(cellEmpty);
        }

        ArrayList<WallCell> wallCells = field.getWallCells();
        for(int i = 0; i < wallCells.size(); i++) {
            CellWallSummerView cellWall = new CellWallSummerView(context);
            cellWall.setDate(sizeCell, wallCells.get(i));
            mCellWinterViews.add(cellWall);
        }

        ArrayList<ContainerCells> actionCells = field.getActionCells();
        for(int i = 0; i < actionCells.size(); i++) {
            CellStartSummerView cellStart = new CellStartSummerView(context);
            CellEndSummerView cellEnd = new CellEndSummerView(context);
            cellStart.setId(actionCells.get(i).getId());
            cellEnd.setId(actionCells.get(i).getId());
            cellStart.setDate(sizeCell, actionCells.get(i).getStartCell());
            cellEnd.setDate(sizeCell, actionCells.get(i).getEndCell());
            mCellWinterViews.add(cellStart);
            mCellWinterViews.add(cellEnd);
        }

        for(int i = 0; i < mCellWinterViews.size(); i++) {
            this.addView(mCellWinterViews.get(i));
        }
    }

    private Cell findTouchCell(int x, int y) {
        for(int i = 0; i < mCellWinterViews.size(); i++) {
            CellSummerView view = mCellWinterViews.get(i);
            if(view.getCell().getX() == x && view.getCell().getY() == y) {
                return view.getCell();
            }
        }
        return null;
    }
}
