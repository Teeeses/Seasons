package com.explead.twoseasons.views.summer_views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import com.explead.twoseasons.logic.elements.Cell;
import com.explead.twoseasons.logic.elements.EmptyCell;
import com.explead.twoseasons.logic.elements.EndCell;
import com.explead.twoseasons.logic.elements.StartCell;
import com.explead.twoseasons.logic.elements.summer_elements.FieldSummer;
import com.explead.twoseasons.logic.elements.WallCell;

import java.util.ArrayList;

/**
 * Created by Александр on 09.07.2017.
 */

public class FieldSummerView extends RelativeLayout {

    public interface OnActionField {
        void onFingerUp(int x, int y);
        void onFingerMove(int x, int y);
        void onFingerDown(int x, int y);
    }

    private CellSummerView[][] workingField;

    private ArrayList<CellSummerView> path;

    private OnActionField onActionField;
    private Context context;


    private int lastX = -1;
    private int lastY = -1;

    private float size;
    private float sizeCell;
    private FieldSummer field;

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
        setOnTouch();
    }

    public void setOnTouch() {
        this.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        final int x = (int) (event.getX() / (size/field.getSizeField()));
                        final int y = (int) (event.getY() / (size/field.getSizeField()));
                        if(findCellView(x, y)) {
                            Log.d("TAG", "UP");
                            onActionField.onFingerDown(x, y);
                        }
                        break;
                    }
                    case MotionEvent.ACTION_MOVE: {
                        final int x = (int) (event.getX() / (size/field.getSizeField()));
                        final int y = (int) (event.getY() / (size/field.getSizeField()));
                        if(x >= 0 && y >= 0 && x < field.getSizeField() && y < field.getSizeField()) {
                            if (x != lastX || y != lastY) {
                                lastX = x;
                                lastY = y;
                                Log.d("TAG", "MOVE");
                                onActionField.onFingerMove(x, y);
                            }
                        }
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        final int x = (int) (event.getX() / (size/field.getSizeField()));
                        final int y = (int) (event.getY() / (size/field.getSizeField()));
                        onActionField.onFingerUp(x, y);
                        break;
                    }
                    default:
                        break;
                }
                return true;
            }
        });
    }

    public void setOnActionField(OnActionField onActionField) {
        this.onActionField = onActionField;
    }

    /**
     * Создаем поле игры
     * @param size - размер поля
     * @param field - данные для построения
     */
    public void createField(float size, FieldSummer field) {
        this.size = size;
        this.field = field;

        workingField = new CellSummerView[field.getSizeField()][field.getSizeField()];
        path = new ArrayList<>();

        RelativeLayout.LayoutParams params = new LayoutParams((int)size, (int)size);
        params.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        this.setLayoutParams(params);

        sizeCell = size/field.getSizeField();

        Cell[][] workingField = field.getWorkingField();

        for(int i = 0; i < field.getSizeField(); i++) {
            for(int j = 0; j < field.getSizeField(); j++) {
                if(workingField[i][j] instanceof WallCell) {
                    CellWallSummerView cell = new CellWallSummerView(context);
                    cell.setDate(sizeCell, workingField[i][j]);
                    this.workingField[i][j] = cell;
                    this.addView(cell);
                } else if(workingField[i][j] instanceof EmptyCell) {
                    CellEmptySummerView cell = new CellEmptySummerView(context);
                    cell.setDate(sizeCell, workingField[i][j]);
                    this.workingField[i][j] = cell;
                    this.addView(cell);
                } else if(workingField[i][j] instanceof EndCell) {
                    CellEndSummerView cell = new CellEndSummerView(context, workingField[i][j].getId());
                    cell.setDate(sizeCell, workingField[i][j]);
                    this.workingField[i][j] = cell;
                    this.addView(cell);
                } else if(workingField[i][j] instanceof StartCell) {
                    CellStartSummerView cell = new CellStartSummerView(context, workingField[i][j].getId());
                    cell.setDate(sizeCell, workingField[i][j]);
                    this.workingField[i][j] = cell;
                    this.addView(cell);
                }
            }
        }
    }

    public void addCellOnPath(Cell cell) {
        CellBetweenSummerView betweenSummerView = new CellBetweenSummerView(context, cell.getId());
        betweenSummerView.setDate(sizeCell, cell);
        path.add(betweenSummerView);
        this.addView(betweenSummerView);
    }

    public void deleteAllPath() {
        for(int i = 0; i < path.size(); i++) {
            this.removeView(path.get(i));
        }
        path.clear();
    }

    public void deleteLastFromPath() {
        this.removeView(path.get(path.size()-1));
        path.remove(path.get(path.size()-1));
    }

    public void addingPathOnField() {
        for(int i = 0; i < path.size(); i++) {
            CellSummerView cell = path.get(i);
            workingField[cell.getCell().getY()][cell.getCell().getX()] = cell;
        }
        path.clear();
    }

    private boolean findCellView(int x, int y) {
        if(workingField[y][x] instanceof CellStartSummerView || workingField[y][x] instanceof CellEndSummerView) {
            return true;
        }
        return false;
    }

}
