package com.explead.twoseasons.views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.explead.twoseasons.logic.elements.Cell;
import com.explead.twoseasons.logic.elements.ContainerCells;
import com.explead.twoseasons.logic.elements.EmptyCell;
import com.explead.twoseasons.logic.elements.Field;
import com.explead.twoseasons.logic.elements.StartCell;
import com.explead.twoseasons.logic.elements.WallCell;

import java.util.ArrayList;

/**
 * Created by Александр on 09.07.2017.
 */

public class SummerFieldView extends RelativeLayout {

    public interface OnActionField {
        void onUp(int x, int y);
        void onMove(int x, int y);
        void onDown(int x, int y);
    }

    private OnActionField onActionField;
    private Context context;

    private ArrayList<CellView> cellViews = new ArrayList<>();

    private float size;
    private Field field;

    public SummerFieldView(Context context) {
        super(context);
        init(context);
    }

    public SummerFieldView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SummerFieldView(Context context, AttributeSet attrs, int defStyleAttr) {
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
            CellEmptyView cellEmpty = new CellEmptyView(context);
            cellEmpty.setDate(sizeCell, emptyCells.get(i));
            cellEmpty.setAlpha(0.25f);
            cellViews.add(cellEmpty);
        }

        ArrayList<WallCell> wallCells = field.getWallCells();
        for(int i = 0; i < wallCells.size(); i++) {
            CellWallView cellWall = new CellWallView(context);
            cellWall.setDate(sizeCell, wallCells.get(i));
            cellViews.add(cellWall);
        }

        ArrayList<ContainerCells> actionCells = field.getActionCells();
        for(int i = 0; i < actionCells.size(); i++) {
            CellStartView cellStart = new CellStartView(context);
            CellEndView cellEnd = new CellEndView(context);
            cellStart.setId(actionCells.get(i).getId());
            cellEnd.setId(actionCells.get(i).getId());
            cellStart.setDate(sizeCell, actionCells.get(i).getStartCell());
            cellEnd.setDate(sizeCell, actionCells.get(i).getEndCell());
            cellViews.add(cellStart);
            cellViews.add(cellEnd);
        }

        for(int i = 0; i < cellViews.size(); i++) {
            this.addView(cellViews.get(i));
        }
    }

    private Cell findTouchCell(int x, int y) {
        for(int i = 0; i < cellViews.size(); i++) {
            CellView view = cellViews.get(i);
            if(view.getCell().getX() == x && view.getCell().getY() == y) {
                return view.getCell();
            }
        }
        return null;
    }
}
